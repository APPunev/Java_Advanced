package StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EXR_LineNumber {
    public static void main(String[] args) throws IOException {
        String path = "/Users/atanaspunev/Downloads" +
                "/Java_Advanced/Java_Advanced" +
                "/Files-and-Streams-Exercises-Resources" +
                "/inputLineNumbers.txt";


        List<String> allLines = Files.readAllLines(Path.of(path));
        BufferedWriter bfr = new BufferedWriter(new FileWriter("output.txt"));

        int counter = 1;

        for (String line:allLines) {
            bfr.write(counter++ + ". " + line);
            bfr.newLine();
        }
        bfr.close();
    }

}
