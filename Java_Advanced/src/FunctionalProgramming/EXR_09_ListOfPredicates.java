package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EXR_09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upper = Integer.parseInt(scanner.nextLine());
        //10

        int[] range = IntStream.rangeClosed(1,upper).toArray();

        int[] dividers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        //10 20 30 40

        BiFunction<int[],int[], List<Integer>> filteredValues = (rangeN, dividersN)->{

            List<Integer> list = Arrays.stream(rangeN)
                    .boxed()
                    .filter(x -> {
                        boolean isDividible = true;
                        for (int i = 0; i < dividersN.length; i++) {
                            int currentDivider = dividersN[i];
                            if (x % currentDivider != 0) {
                                int n = x % currentDivider;
                                isDividible = false;
                            }
                        }
                        return isDividible;
                    }).collect(Collectors.toList());
            return list;
        };

        filteredValues.apply(range,dividers).forEach(e -> System.out.print(e + " "));
    }
}
