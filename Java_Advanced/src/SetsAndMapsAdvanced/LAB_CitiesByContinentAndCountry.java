package SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class LAB_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Info> compassMap = new LinkedHashMap<String, Info>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String countryName = input.split("\\s+")[1];
            String cityName = input.split("\\s+")[2];


            Info info = new Info(new ArrayList<>(),new ArrayList<>());

            if (compassMap.containsKey(continent)) {
                if (info.getCountry().equals(countryName)) {
                    compassMap.get(continent).addCity(cityName);
                }else{
                    compassMap.get(continent).addCountry(countryName);
                    compassMap.get(continent).addCity(cityName);
                }
            }else{
                if (info.getCountry().equals(countryName)) {
                    compassMap.get(continent).getCountry().add(cityName);;
                }else{
                    compassMap.put(continent,info);
                    compassMap.get(continent).addCountry(countryName);
                    compassMap.get(continent).addCity(cityName);
                }
            }
        }

//        compassMap.entrySet()
//                .forEach(el->{
//                    System.out.println(el.getKey() + ":");
//                    List<Info> newList = el.getValue();
//                    newList.forEach(e-> System.out.printf(""));
//                });
    }


    public static class Info{
        private List<String> country;
        private List<String> city;

        public Info(List<String> country, List<String> city) {
            this.country = country;
            this.city = city;
        }

        public void addCity(String cityName){
            city.add(cityName);
        }

        public void addCountry(String countryName){
            country.add(countryName);
        }

        public List<String> getCountry() {
            return country;
        }

        public List<String> getCity() {
            return city;
        }
    }
}
