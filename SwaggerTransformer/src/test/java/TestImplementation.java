import utils.TransformUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestImplementation {

    public static void main(String[] args) throws Exception {

        String inputFilePath = inputFilePath();

        TransformUtils.transfromEdmxToSwagger(inputFilePath);

    }

    public static String inputFilePath() {
        System.out.println("Input the full path of the file you want to transform:");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Error occur when read source file path!");
            return null;
        }
    }
}
