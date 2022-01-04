package SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class EXR_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();// Ce O
            String[] tokens = input.split("\\s+");
            for (String str:tokens) {
                set.add(str);
            }
        }
        System.out.println(String.join(" ",set));
    }
}
