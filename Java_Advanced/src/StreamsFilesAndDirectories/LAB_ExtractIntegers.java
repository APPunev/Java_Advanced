package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LAB_ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-LAB-Resources/input.txt";
        String output = "04.ExtractIntegersOutput.txt";

        try(FileInputStream fis = new FileInputStream(path);
            FileOutputStream fos = new FileOutputStream(output);
            Scanner scanner = new Scanner(fis);
            PrintWriter printWriter = new PrintWriter(output)) {
            while(scanner.hasNext()){
                if (scanner.hasNextInt()) {
                    int oneInt = scanner.nextInt();
                    printWriter.println(oneInt);
                }else{
                    scanner.next();
                }
            }
        }
    }
}
