package SetsAndMapsAdvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EXR_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String,Integer>> ipMap = new TreeMap<>();

        Pattern pattern = Pattern.compile("IP=(?<IP>.+)\\smessage=(?<message>'|.+') user=(?<user>.+)");
        while(!input.equals("end")){
            Matcher matcher = pattern.matcher(input);

            String address = "";
            String message = "";
            String user = "";

            while(matcher.find()){
                address = matcher.group("IP");
                message = matcher.group("message");
                user = matcher.group("user");
            }

            if (ipMap.containsKey(user)) {
                if (ipMap.get(user).containsKey(address)) {
                    int currentCount = ipMap.get(user).get(address);
                    ipMap.get(user).put(address,++currentCount);
                }else{
                    ipMap.get(user).put(address,1);
                }
            }else{
                ipMap.put(user, new LinkedHashMap<>());
                ipMap.get(user).put(address,1);
            }

            input = scanner.nextLine();
        }

        ipMap.entrySet().forEach(en->{
            System.out.println(en.getKey() + ": ");
            LinkedHashMap<String,Integer> newMap = en.getValue();
            int counter = newMap.size() - 1;
            for (Map.Entry<String, Integer> e : newMap.entrySet()) {
                if (counter != 0) {
                    System.out.print(e.getKey() + " => " + e.getValue() + ", ");
                } else {
                    System.out.print(e.getKey() + " => " + e.getValue() + ".");
                }
                counter--;
            }
            System.out.println();
        });
    }
}
