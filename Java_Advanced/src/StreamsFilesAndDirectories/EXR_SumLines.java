package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EXR_SumLines {
    public static void main(String[] args) throws IOException {
        String path = "/Users/atanaspunev/Downloads/Java_Advanced" +
                "/Java_Advanced/Files-and-Streams-Exercises-Resources" +
                "/input.txt";


        List<String> allLines = Files.readAllLines(Path.of(path));

//        for (String line:allLines) {
//            int sum = 0;
//            for (int i = 0; i < line.length(); i++) {
//                char current = line.charAt(i);
//                sum += current;
//            }
//            System.out.println(sum);
//        }
        allLines.stream()
                .map(String::toCharArray)
                .forEach(
                        charArray->{
                            int sum = 0;
                            for (char c:charArray) {
                                sum += c;
                            }
                            System.out.println(sum);
                        }
                );
    }
}
