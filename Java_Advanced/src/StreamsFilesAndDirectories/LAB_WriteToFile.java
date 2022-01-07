package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class LAB_WriteToFile {
    public static void main(String[] args) throws IOException {


        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-LAB-Resources/input.txt";
        String output = "02.WriteToFileOutput.txt";

        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(output);

        Set<Character> punctuation = Set.of(',', '.', '!', '?');

        int oneByte = fis.read();
        while(oneByte != -1){
            if (!punctuation.contains((char)oneByte)) {
                fos.write(oneByte);
            }
            oneByte = fis.read();
        }

    }
}
