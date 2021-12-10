package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        //2 + 5 + 10 - 2 - 1
        String[] tokens = input.split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--) {
            stack.push(tokens[i]);
        }

        while(stack.size() > 1){
            int leftOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int rightOperand = Integer.parseInt(stack.pop());

            int result = operator.endsWith("+")
                    ? leftOperand + rightOperand
                    : leftOperand - rightOperand;

            stack.push(String.valueOf(result));
        }

        System.out.println(stack.pop());
    }
}
