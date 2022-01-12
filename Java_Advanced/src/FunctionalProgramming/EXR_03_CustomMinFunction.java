package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class EXR_03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int nums = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .min().orElse(0);
//
//        System.out.println(nums);

        String input = scanner.nextLine();
        int [] numbers = Arrays
                .stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> printMin = arr -> System.out.println(Arrays.stream(arr).min().getAsInt());
        printMin.accept(numbers);
    }
}
