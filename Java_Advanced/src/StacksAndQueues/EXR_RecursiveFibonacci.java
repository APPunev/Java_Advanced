package StacksAndQueues;

import java.util.Scanner;
public class EXR_RecursiveFibonacci {
    public static long[] numbers;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long result = fib(n);

        System.out.println(result);
        scanner.close();
    }

    private static long fib(int n){
        long[] fibonacciNumbers = new long[n + 1];

        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i <=n ; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[ i - 1] + fibonacciNumbers[i - 2];
        }
        return fibonacciNumbers[n];
    }
}