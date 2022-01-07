package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class LAB_ReadFile {
    public static void main(String[] args) {

        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-LAB-Resources/input.txt";

        try (FileInputStream fis = new FileInputStream(path)) {
            int oneByte = fis.read();
            while(oneByte!= -1){
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fis.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
