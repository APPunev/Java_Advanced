package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;

public class LAB_ListFiles {
    public static void main(String[] args) throws IOException {

        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-LAB-Resources/Files-and-Streams";
        File filesAndStreamsDir = new File(path);

        for (File file : filesAndStreamsDir.listFiles()) {
            if (file.isFile()) {
                System.out.printf("%s: [%d]%n",file.getName(),file.length());
            }
        }
    }
}
