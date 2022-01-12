package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class EXR_01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printName = str -> System.out.println(str);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printName);
    }
}
