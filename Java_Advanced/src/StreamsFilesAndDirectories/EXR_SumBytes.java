package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EXR_SumBytes {
    public static void main(String[] args) throws IOException{
        String path = "/Users/atanaspunev/Downloads/Java_Advanced" +
                "/Java_Advanced/Files-and-Streams-Exercises-Resources" +
                "/input.txt";

        byte[] allBytes = Files.readAllBytes(Path.of(path));
        long sum = 0;

        for (byte value:allBytes) {
            if (value != 10 && value != 13) {
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
