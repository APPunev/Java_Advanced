package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LAB_SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]nums = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
            }else{
                System.out.print(nums[i] + ", ");
            }
        }

        String numsStr = Arrays.stream(nums)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));


        System.out.println();

        System.out.println(numsStr);
    }
}
