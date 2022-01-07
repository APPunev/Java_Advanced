package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class LAB_SortLines {
    public static void main(String[] args) throws IOException {

        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-LAB-Resources/input.txt";
        String output = "06.SortLinesOutput.txt";

        List<String> allLines = Files.lines(Path.of(path))
                .sorted()
                .collect(Collectors.toList());

        Files.write(Path.of(output),allLines);

    }
}
