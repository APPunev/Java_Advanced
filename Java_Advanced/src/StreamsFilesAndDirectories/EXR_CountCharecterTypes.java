package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EXR_CountCharecterTypes {
    public static void main(String[] args) throws IOException {
        String path = "/Users/atanaspunev/Downloads/Java_Advanced" +
                "/Java_Advanced/Files-and-Streams-Exercises-Resources" +
                "/input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));

        int countVowels = 0;
        int countConsonats = 0;
        int countpunctuation = 0;

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);
                if (current == 'a' || current == 'e' || current == 'o'
                        || current == 'i' || current == 'u') {
                    countVowels++;
                }else if(current == '?' || current == '!'
                        || current == '.' || current == ','){
                    countpunctuation++;
                } else{
                    if (current != ' ') {
                        countConsonats++;
                    }
                }
            }
        }
        BufferedWriter bfr = new BufferedWriter(new FileWriter("output.txt"));
        bfr.write("Vowels: " + countVowels);
        bfr.newLine();
        bfr.write("Consonants: " + countConsonats);
        bfr.newLine();
        bfr.write("Punctuation: " + countpunctuation);
        bfr.newLine();
        bfr.close();

    }
}
