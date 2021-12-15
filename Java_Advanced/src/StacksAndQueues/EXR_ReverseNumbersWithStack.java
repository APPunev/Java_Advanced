package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EXR_ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String n:numbers) {
            stack.push(n);
        }
        System.out.println(String.join(" ", stack));
    }
}
