package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LAB_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (String str : input) {
            if (str.length() == 1) {
                str = str + ".0";
            }

            if (map.containsKey(str)) {
                int currentCount = map.get(str);
                map.put(str, ++currentCount);
            } else {
                map.put(str, 1);
            }
        }

        map.entrySet().forEach(el -> System.out.printf("%.1f -> %d%n",Double.parseDouble(el.getKey()) ,el.getValue()));
    }
}
