package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;

public class EXR_GetFolderSize {
    public static void main(String[] args) throws IOException {

        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-Exercises-Resources/Exercises Resources";

        File folder = new File(path);
        File[] filesFolder = folder.listFiles();
        int size = 0;
        for (File file:filesFolder) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);
    }
}
