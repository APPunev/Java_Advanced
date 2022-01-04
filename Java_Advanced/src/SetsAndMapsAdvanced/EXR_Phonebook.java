package SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EXR_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Pattern pattern = Pattern.compile("(.+)-(.+)");

        HashMap<String, String> bookMap = new HashMap<>();
        while(!(input = scanner.nextLine()).equals("search")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                bookMap.put(matcher.group(1), matcher.group(2));
            }
        }

        while(!(input = scanner.nextLine()).equals("stop")){
            if (bookMap.containsKey(input)) {
                System.out.format("%s -> %s\n",input,bookMap.get(input));
            }else{
                System.out.format("Contact %s does not exist.\n",input);

            }
        }
    }
}