package StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class EXR_WordCount {
    public static void main(String[] args) throws IOException {
        String pathWords = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-Exercises-Resources/words.txt";
        String pathMatch = "/Users/atanaspunev/Downloads/Java_Advanced/Java_Advanced/Files-and-Streams-Exercises-Resources/text.txt";

        List<String> wordToMatch = new ArrayList<>();
        List<String> matchers = new ArrayList<>();

        Scanner words = new Scanner(Files.readString(Path.of(pathWords)));
        while(words.hasNext()){
            wordToMatch.add(words.next());
        }
        Scanner matcher = new Scanner(Files.readString(Path.of(pathMatch)));
        while(matcher.hasNext()){
            matchers.add(matcher.next());
        }

        LinkedHashMap<String, Integer> theMap = new LinkedHashMap<>();
        for (String word:wordToMatch) {
            theMap.put(word,0);
        }

        BufferedWriter bfr = new BufferedWriter(new FileWriter("resilt.txt"));
        for (String matcherWord:matchers) {
            if (theMap.containsKey(matcherWord)) {
                theMap.put(matcherWord, theMap.get(matcherWord) + 1);
            }
        }

        theMap.entrySet()
                .stream()
                .forEach(entry-> {
                    try {
                        bfr.write(entry.getKey() + " - " + entry.getValue());
                        bfr.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bfr.close();
    }
}
