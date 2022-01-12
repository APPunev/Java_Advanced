package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LAB_FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int lower = Integer.parseInt(tokens[0]);
        int upper = Integer.parseInt(tokens[1]);

        String filterWord = scanner.nextLine();

        Predicate<Integer> filter = getFilter(filterWord);

        Consumer<Integer> printer = x -> System.out.print(x + " ");

        IntStream.rangeClosed(lower,upper)
                .boxed()
                .filter(filter)
                .forEach(printer);




    }
    public static Predicate<Integer> getFilter(String filter){
        if (filter.equals("odd")) {
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }
}
