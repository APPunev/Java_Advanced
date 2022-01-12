package FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EXR_07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>,Integer> minNum = list ->
                list.stream()
                .mapToInt(Integer::intValue)
                        .min().getAsInt();

        System.out.println(numbers.lastIndexOf(minNum.apply(numbers)));
    }
}
