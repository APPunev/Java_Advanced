package SetsAndMapsAdvanced;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EXR_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Pattern pattern = Pattern.compile("(?<singer>.+) @(?<city>.+) (?<tiketPrice>[0-9]+) (?<tiketsCount>[0-9]+)");

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venueMap = new LinkedHashMap<>();

        while(!(input = scanner.nextLine()).equals("End")){
            Matcher matcher = pattern.matcher(input);
            String singer = "";
            String city = "";
            int ticketPrice = 0;
            int ticketsCount = 0;
            while(matcher.find()){
                singer = matcher.group("singer");
                city = matcher.group("city");
                ticketPrice = Integer.parseInt(matcher.group("tiketPrice"));
                ticketsCount = Integer.parseInt(matcher.group("tiketsCount"));

                int price = ticketPrice * ticketsCount;

                venueMap.putIfAbsent(city, new LinkedHashMap<>());
                venueMap.get(city).putIfAbsent(singer, 0);
                venueMap.get(city).put(singer, venueMap.get(city).get(singer) + price);
            }

        }
        venueMap.forEach((key1, value) -> {
            System.out.println(key1);
            value.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(entry ->
                            System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));
        });
    }
}
