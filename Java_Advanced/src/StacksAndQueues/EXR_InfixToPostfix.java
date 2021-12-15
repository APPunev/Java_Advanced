package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EXR_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (char c:input.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (Character.isLetterOrDigit(c)) {
                queue.offer(c);
            }else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while(!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())){
                    queue.offer(stack.pop());
                }
                stack.push(c);
            }else if (c == ')') {
                char ch = stack.peek();
                while(!stack.isEmpty() && stack.peek() != '('){
                    queue.offer(stack.pop());
                }
                stack.pop();
            }else if (c == '(') {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                System.out.println("This expression is invalid");
            queue.offer(stack.pop());
        }
        queue.forEach(e -> System.out.print(e + " "));
    }

    private static int getPrecedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }
}
