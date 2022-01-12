package FunctionalProgramming;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.function.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Function<приема, връща> - приема и връща стойност
        Function<Integer, Integer> calculateSum = x -> x + x;
        int sum = calculateSum.apply(5);
        System.out.println(sum);

        //2. Consumer<приема> - приема, но не връща стойност (void)
        Consumer<Integer> printNumber = n -> System.out.println(n);
        Consumer<Integer> changeVariable = n -> n = n + 5;
        printNumber.accept(5);//където n == 5;

        //3. Supplier<връща> - не приема стойност, а само връща
        Supplier<String> getName = () -> scanner.nextLine();
        getName.get();

        //4. Predicate<приема> - приема стойност и връща true/false
        Predicate<Integer> isOdd = n -> n % 2 == 1;
        boolean isOddNumber = isOdd.test(6);

        //5. BiFunction<приема1, приема2, връща> - приема 2 стойности и връща трета/ресултат
        BiFunction<Integer, Integer, Integer> sumOfIntegers = (x, y) -> x + y;
        System.out.println(sumOfIntegers.apply(3,4));

        //6. Comparator<връща> - сравнява 2 числа и връща стойност.
        // компаратора сравнява и разменя местата спрямо върнатите стойности:
        //(а,б)-> ако резултата е:
        //а < б-> -1 - няма размяна
        //а == б -> 0
        //а > б -> 1 - има размяна

        Comparator<Integer> comparator = ((a,b)->{
            if (a % 2 == 0 && b % 2 == 1) {
                return -1;
            } else if (a % 2 == 1 && b % 2 == 0) {
                return 1;
            }else if(a % 2 == 0 && b % 2 == 0 || a % 2 == 1 && b % 2 == 1){
                if (a <= b) {
                    return -1;
                }else {
                    return 1;
                }
            }
            return 0;
        });
    }
}
