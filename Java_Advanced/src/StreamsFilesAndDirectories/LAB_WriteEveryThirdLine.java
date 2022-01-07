package StreamsFilesAndDirectories;

import java.io.*;

public class LAB_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-LAB-Resources/input.txt";
        String output = "05.WriteEveryThirdLineOutput.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path));
            PrintWriter pr = new PrintWriter(new FileOutputStream(output))){

            String line = br.readLine();
            int counter = 1;
            while(line != null){
                if (counter%3==0) {
                    pr.println(line);
                }
                counter++;
                line = br.readLine();
            }
        }
    }
}
