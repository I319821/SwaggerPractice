package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    static public String getFileNameByPath(String filePath) {
        if (filePath == null) return null;

        if (filePath.isEmpty()) return "";

        if (filePath.contains("\\")) {
            return filePath.substring(filePath.lastIndexOf("\\") + 1);
        } else {
            return filePath;
        }
    }

    static public String getFileNameWithoutSuffix(File file) {
        String fileName = file.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    static public String getFileNameWithoutSuffixByPath(String filePath) {
        String fullFileName = getFileNameByPath(filePath);

        if (fullFileName == null) return null;

        if (fullFileName.isEmpty()) return "";

        return fullFileName.substring(0, fullFileName.lastIndexOf("."));
    }


    static public InputStream buildFileInputStream(String sourceFilePath) throws IOException {
        File inputFile = new File(sourceFilePath);
        createFileWhenNonExists(inputFile);
        return new FileInputStream(inputFile);
    }

    static public void createFileWhenNonExists(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
