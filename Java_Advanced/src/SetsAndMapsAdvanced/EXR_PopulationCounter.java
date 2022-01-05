package SetsAndMapsAdvanced;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EXR_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, List<CityData>> populationMap = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("(?<city>.+)\\|(?<country>.+)\\|(?<population>.+)");

        String country = "";
        String city = "";
        long population = 0L;


        while(!input.equals("report")){
            Matcher matcher = pattern.matcher(input);
            while(matcher.find()){
                country = matcher.group("country");
                city = matcher.group("city");
                population = Integer.parseInt(matcher.group("population"));
            }

            CityData cityData = new CityData(city,population);

            if (populationMap.containsKey(country)) {
                populationMap.get(country).add(cityData);
            }else{
                populationMap.put(country, new ArrayList<>());
                populationMap.get(country).add(cityData);
            }

            input = scanner.nextLine();
        }

        populationMap.entrySet().stream()
                .sorted((e1,e2)-> Long.compare(getTotalPopulation(e2),getTotalPopulation(e1)))
                .forEach(e->{
                    System.out.println(e.getKey() + " (total population: " + getTotalPopulation(e) + ")");
                    List<CityData>currentList = e.getValue();
                    currentList.stream().sorted(Comparator.comparing(CityData::getPopulation).reversed()).forEach(el->{
                        System.out.println("=>" + el.getCity() + ": " + el.getPopulation());
                    });
                });
    }

    private static long getTotalPopulation(Map.Entry<String, List<CityData>> e) {
        List<CityData> current = e.getValue();
        long result = 0;
        for (CityData data:current) {
            result += data.getPopulation();
        }
        return result;
    }

    public static class CityData{
        private String city;
        private long population;

        public CityData(String city, long population) {
            this.city = city;
            this.population = population;
        }

        public String getCity() {
            return city;
        }

        public long getPopulation() {
            return population;
        }
    }
}
