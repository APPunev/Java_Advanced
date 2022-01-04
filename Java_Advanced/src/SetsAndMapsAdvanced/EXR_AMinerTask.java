package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class EXR_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        LinkedHashMap<String, Integer> minerMap = new LinkedHashMap<>();

        while(!(input=scanner.nextLine()).equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());

            if (minerMap.containsKey(input)) {
                int current = minerMap.get(input);
                minerMap.put(input, quantity + current);
            }else{
                minerMap.put(input,quantity);
            }
        }

        minerMap.entrySet()
                .forEach(entry-> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
