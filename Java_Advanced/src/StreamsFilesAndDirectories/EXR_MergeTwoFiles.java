package StreamsFilesAndDirectories;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EXR_MergeTwoFiles {
    public static void main(String[] args) throws IOException{
        String firstPath = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-Exercises-Resources/inputOne.txt";
        String secondPath = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-Exercises-Resources/inputTwo.txt";

        Scanner firstFile = new Scanner(Files.readString(Path.of(firstPath)));
        Scanner secondFile = new Scanner(Files.readString(Path.of(secondPath)));

        List<String> nums = new ArrayList<>();

        while(firstFile.hasNext()){
            nums.add(firstFile.next());
        }

        while(secondFile.hasNext()){
            nums.add(secondFile.next());
        }

        Writer write = new FileWriter("output.txt");
        for (String num:nums) {
            write.write(num + System.lineSeparator());
        }
        write.close();
    }
}
