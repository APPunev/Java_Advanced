package SetsAndMapsAdvanced;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class EXR_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] n1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        LinkedHashSet<Integer> set1 = new LinkedHashSet();
        LinkedHashSet<Integer> set2 = new LinkedHashSet();

        for (int i = 0; i < n1[0]; i++) {
            set1.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < n1[1]; i++) {
            set2.add(Integer.parseInt(scanner.nextLine()));
        }

        LinkedHashSet<Integer> duplicate = new LinkedHashSet<>();
        for (Integer e:set1) {
            if (set2.contains(e)) {
                duplicate.add(e);
            }
        }

        for (Integer integer : duplicate) {
            System.out.print(integer + " ");
        }
    }
}
