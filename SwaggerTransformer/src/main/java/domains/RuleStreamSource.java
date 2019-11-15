package domains;

import utils.FileUtils;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;

public class RuleStreamSource {
    private String ruleFilePath;

    private InputStream ruleInputStream;

    public RuleStreamSource(String ruleFilePath) {
        this.ruleFilePath = ruleFilePath;
    }

    public RuleStreamSource(InputStream ruleInputStream) {
        this.ruleInputStream = ruleInputStream;
    }

    public StreamSource getRuleStreamSource() throws IOException {
        if (this.ruleInputStream != null) {
            return new StreamSource(this.ruleInputStream);
        } else if (this.ruleFilePath != null) {
            return new StreamSource(FileUtils.buildFileInputStream(this.ruleFilePath));
        }

        return null;
    }
}
