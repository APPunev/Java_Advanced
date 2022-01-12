package FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class LAB_SumNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        Function<String[], Stream<Integer>> map = arr -> Arrays.stream(arr)
                .map(Integer::parseInt);


        Function<Stream<Integer>, Integer> sum = str->str.mapToInt(e->e).sum();
        Function<Stream<Integer>, Long> count = str->str.mapToInt(e->e).count();

        Stream<Integer> stream = map.apply(input);
        Stream<Integer> stream2 = map.apply(input);

        System.out.println("Count = " + count.apply(stream));
        System.out.println("Sum = " + sum.apply(stream2));
    }
}
