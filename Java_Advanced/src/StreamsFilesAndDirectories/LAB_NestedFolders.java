package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LAB_NestedFolders {
    public static void main(String[] args) throws IOException {

        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-LAB-Resources/Files-and-Streams";

        File fileAndStrDir = new File(path);
        Deque<File> stack = new LinkedList<>();
        stack.push(fileAndStrDir);

        List<String> fileNames = new ArrayList<>();

        while(!stack.isEmpty()){
            File file = stack.poll();

            fileNames.add(file.getName());
            File[] currentFolderContent = file.listFiles();
            for (File childFile:currentFolderContent) {
                if (childFile.isDirectory()) {
                    stack.offer(childFile);
                }
            }
        }
        for (String fileName:fileNames) {
            System.out.println(fileName);
        }
        System.out.println(fileNames.size() + " folders");
    }
}
