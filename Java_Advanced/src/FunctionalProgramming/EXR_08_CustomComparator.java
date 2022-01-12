package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EXR_08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Comparator<Integer> comparator = ((a,b)->{
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1;
            }else if(a % 2 == 0 && b % 2 == 0 || a % 2 != 0 && b % 2 != 0){
                if (a <= b) {
                    return -1;
                }else {
                    return 1;
                }
            }
            return 0;
        });

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        nums.sort(comparator);

        nums.forEach(el -> System.out.print(el + " "));

    }
}
