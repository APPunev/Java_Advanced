package SetsAndMapsAdvanced;

import java.util.*;

public class LAB_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> destinationMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            if (!destinationMap.containsKey(continent)) {
                destinationMap.put(continent, new LinkedHashMap<>());
                destinationMap.get(continent).put(country,new ArrayList<>());
                destinationMap.get(continent).get(country).add(city);
            }else{
                boolean countryExist = false;
                for (Map.Entry<String, List<String>> el : destinationMap.get(continent).entrySet()) {
                    if (el.getKey().equals(country)) {
                        destinationMap.get(continent).get(country).add(city);
                        countryExist = true;
                    }
                }
                if (!countryExist) {
                    destinationMap.get(continent).put(country, new ArrayList<>());
                    destinationMap.get(continent).get(country).add(city);
                }
            }
        }
            destinationMap.entrySet().forEach(el -> {
                System.out.println(el.getKey() + ":");
                LinkedHashMap<String, List<String>> currentMap = el.getValue();
                currentMap.entrySet().forEach(e->{
                    System.out.print(" " + e.getKey() + " -> ");
                    List<String> currentList = e.getValue();
                    System.out.print(String.join(", ", currentList));
                    System.out.println();
                });
            });
    }
}
