package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class EXR_04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        BiFunction<int[], String, int[]> function = (list, command) -> {
            boolean isTrue = true;
            while(!command.equals("end")){
                switch (command){
                    case "add":
                        add(list);
                        break;
                    case "multiply":
                        multiply(list);
                        break;
                    case "subtract":
                        subtract(list);
                        break;
                    case "print":
                        isTrue = false;
                        printArr(list);
                        break;

                }
                command = scanner.nextLine();
            }
            if (isTrue == true) {
                printArr(list);
            }
            return list;
        };
        function.apply(nums,input);

//        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        Function<int[],int[]> add1 = arr -> Arrays.stream(arr).map(e -> e += 1).toArray();
//        Function<int[],int[]> multiply = arr -> Arrays.stream(arr).map(e -> e*=2).toArray();
//        Function<int[],int[]> subtract = arr -> Arrays.stream(arr).map(e -> e -= 1).toArray();
//        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
//
//
//        String command = "";
//        while(!(command = scanner.nextLine()).equals("end")){
//            if (command.equals("add")) {
//                nums = add1.apply(nums);
//            }else if(command.equals("multiply")){
//               nums = multiply.apply(nums);
//            }else if(command.equals("subtract")){
//                nums = subtract.apply(nums);
//            }else {
//                print.accept(nums);
//                System.out.println();
//            }
//        }
    }

    private static void printArr(int[] list) {
        Arrays.stream(list).forEach(e-> System.out.print(e + " "));
        System.out.println();
    }

    private static void subtract(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i] - 1;
        }
    }

    private static void multiply(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i] *2;
        }
    }

    private static void add(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i] + 1;
        }
    }
}
