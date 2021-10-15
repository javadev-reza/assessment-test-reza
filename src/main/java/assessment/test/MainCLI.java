package assessment.test;

import assessment.test.service.TransformFile;
import io.micronaut.configuration.picocli.PicocliRunner;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.List;

import static picocli.CommandLine.*;

@Command(name = "assessment-test", description = "...",
        mixinStandardHelpOptions = true)
public class MainCLI implements Runnable {

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(MainCLI.class, args);
    }

    @Parameters(index = "0", description = "Source file path")
    private String originalFilePath;

    @Option(names = {"-o", "--output"}, description = "Destination file path: {*.json, *.txt}")
    private String output;

    @Option(names = {"-t", "--target"}, description = "Extension file: {json, txt}", defaultValue = "txt")
    private String target;

    public void run() {
        TransformFile transformFile = new TransformFile();
        if(originalFilePath != null){
            boolean validate = target.matches("txt") || target.matches("json");
            if(validate) {
                if(output.contains(target)){
                    transformFile.writeFile(
                            transformFile.readFile(
                                    transformFile.getFile(originalFilePath)),
                            output, target);
                } else {
                    System.out.println(
                            "file type on '-output' option value and '-t' option value do not match");
                }
            } else {
                System.out.println(
                        "the '-t' option contains only 'txt' & 'json' values");
            }
        }
    }
}
