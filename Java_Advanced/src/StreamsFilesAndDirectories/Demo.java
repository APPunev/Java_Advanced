package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {

        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/input.txt";

        FileInputStream fis = new FileInputStream(path);

        int oneByte = fis.read();

        while (oneByte != -1) {
            System.out.println(oneByte + " "
                    + Integer.toBinaryString(oneByte) + " "
                    + "0x" + Integer.toHexString(oneByte) + " "
                    + (char) oneByte);
            oneByte = fis.read();
        }
    }
}
