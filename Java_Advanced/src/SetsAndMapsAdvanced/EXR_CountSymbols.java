package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeMap;

public class EXR_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (symbols.containsKey(input.charAt(i))){
                int currentCount = symbols.get(input.charAt(i));
                symbols.put(input.charAt(i), ++currentCount);
            }else{
                symbols.put(input.charAt(i), 1);
            }
        }

        symbols.entrySet()
                .stream()
                .forEach(el-> System.out.println(el.getKey() + ": " + el.getValue() + " time/s"));
    }
}
