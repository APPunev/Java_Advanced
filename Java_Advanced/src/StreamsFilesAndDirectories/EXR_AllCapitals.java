package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EXR_AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "/Users/atanaspunev/Downloads/Java_Advanced" +
                "/Java_Advanced/Files-and-Streams-Exercises-Resources" +
                "/input.txt";

        BufferedWriter bfr = new BufferedWriter(new FileWriter("output.txt"));

        Files.readAllLines(Path.of(path)).forEach(
                line->{
                    try {
                        bfr.write(line.toUpperCase());
                        bfr.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        bfr.close();
    }
}
