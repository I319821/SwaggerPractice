package domains;

import utils.FileUtils;

import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class InputStreamSource {

    String sourceFilePath;

    InputStream inputStream;

    public InputStreamSource(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public InputStreamSource(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public StreamSource getInputFileStreamSource() throws IOException {

        if(this.inputStream != null){
            return new StreamSource(this.inputStream);
        }else if(this.sourceFilePath != null){
            return new StreamSource(FileUtils.buildFileInputStream(this.sourceFilePath));
        }
        return null;
    }
}
