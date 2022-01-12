package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LAB_CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUpper = str ->
                Character.isUpperCase(str.charAt(0));

        List<String> text = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .filter(isUpper)
                .collect(Collectors.toList());


        System.out.println(text.size());
        text.forEach(e -> System.out.println(e));
    }
}
