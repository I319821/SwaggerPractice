package utils;

import domains.InputStreamSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TransformUtils {

    private static String V2_TO_V4_RULE_PATH = "V2-to-V4-CSDL.xsl";
    private static String V4_TO_SWAGGER_RULE_PATH = "V4-CSDL-to-OpenAPI.xsl";

    public static void transform(StreamSource fileToTransfrom, StreamResult resultStream, StreamSource rules)
            throws Exception {
        if (fileToTransfrom == null || rules == null)
            throw new Exception("Source file and rules cannot be null!");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(rules);
        transformer.setParameter("openapi-version", "3.0");
        transformer.setParameter("pretty", true);
        transformer.setParameter("diagram", true);
        transformer.transform(fileToTransfrom, resultStream);
    }

    public static void transformV2ToV4(StreamSource inputStreamSource, StreamResult resultStream)
            throws Exception {
        StreamSource v2ToV4RuleStream = new InputStreamSource(V2_TO_V4_RULE_PATH).getInputFileStreamSource();
        transform(inputStreamSource, resultStream, v2ToV4RuleStream);
    }

    public static void transformV4ToSwagger(StreamSource v4StreamSource, StreamResult streamResult)
            throws Exception {
        StreamSource v4ToSwaggerRuleStream = new InputStreamSource(V4_TO_SWAGGER_RULE_PATH).getInputFileStreamSource();
        transform(v4StreamSource, streamResult, v4ToSwaggerRuleStream);
    }

    public static void transfromEdmxToSwagger(String inputFilePath) throws Exception {

        //Transform v2 EDMX file to v4 EDMX file
        File v4ResultFile = new File(FileUtils.getFileNameWithoutSuffixByPath(inputFilePath).concat("_V4_edmx.xml"));
        FileUtils.createFileWhenNonExists(v4ResultFile);
        StreamResult v4ResultStream = new StreamResult(new FileOutputStream(v4ResultFile));
        StreamSource v2StreamSource = new StreamSource(new FileInputStream(inputFilePath));
        transformV2ToV4(v2StreamSource, v4ResultStream);

        //Transform v4 EDMX file to swagger file
        File swaggerReulstFile = new File(FileUtils.getFileNameWithoutSuffixByPath(inputFilePath).concat(".json"));
        FileUtils.createFileWhenNonExists(swaggerReulstFile);
        StreamResult swaggerResultStream = new StreamResult(new FileOutputStream(swaggerReulstFile));
        StreamSource v4StreamSource = new StreamSource(new FileInputStream(v4ResultFile));
        transformV4ToSwagger(v4StreamSource, swaggerResultStream);
    }

}
