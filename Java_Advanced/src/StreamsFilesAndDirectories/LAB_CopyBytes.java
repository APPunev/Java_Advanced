package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LAB_CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-LAB-Resources/input.txt";
        String output = "03.CopyBytesOutput.txt";

        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(output);

        int oneByte = fis.read();
        while(oneByte != -1){
            String number = String.valueOf(oneByte);
            if (oneByte == ' '||oneByte == '\n') {
                fos.write(oneByte);
            }else{
                for (int i = 0; i < number.length(); i++) {
                    fos.write(number.charAt(i));
                }
            }

            oneByte = fis.read();
        }

    }
}
