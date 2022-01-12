package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LAB_FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> namesAndAge = new LinkedHashMap<>();

        while(n-- > 0){
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            namesAndAge.put(name,age);
        }

        String ageCondition = scanner.nextLine();
        int ageFilterRequired = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Map.Entry<String,Integer>> ageFilter = getAgeFiter(ageFilterRequired,ageCondition);

        namesAndAge.entrySet()
                .stream()
                .filter(getAgeFiter(ageFilterRequired,ageCondition))
                .forEach(getFormater(format));
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFiter(int age, String condition) {
        if (condition.equals("older")) {
            return e-> e.getValue() >= age;
        }
        return e-> e.getValue() <= age;
    }

    public static Consumer<Map.Entry<String,Integer>> getFormater(String format){
        if (format.equals("name")) {
            return entry -> System.out.println(entry.getKey());
        }else if(format.equals("age")){
            return entry -> System.out.println(entry.getValue());
        }else{
            return entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
