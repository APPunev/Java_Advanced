package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EXR_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\.uk|\\.com|\\.us");

        String input = "";

        LinkedHashMap<String, String> emailMap = new LinkedHashMap<>();

        while(!(input = scanner.nextLine()).equals("stop")){
            String email = scanner.nextLine();

            Matcher matcher = pattern.matcher(email);

            if (matcher.find()) {
                continue;
            }
            else{
                emailMap.put(input, email);
            }
        }

        emailMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
