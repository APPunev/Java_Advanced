package StacksAndQueues;


import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] token = input.split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String c:token) {

            if (isLetterOrDigit(c)) {
                queue.offer(c);
            }else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                while(!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())){
                    queue.offer(stack.pop());
                }
                stack.push(c);
            }else if (c.equals(")")) {
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    queue.offer(stack.pop());
                }
                stack.pop();
            }else if (c.equals("(")) {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek().equals("("))
                System.out.println("This expression is invalid");
            queue.offer(stack.pop());
        }
        queue.forEach(e -> System.out.print(e + " "));
    }

    private static boolean isLetterOrDigit(String c) {
        if (c.length()> 1) {
            for (int i = 0; i < c.length(); i++) {
                char a = c.charAt(i);
                if (!Character.isLetterOrDigit(a)) {
                    return false;
                }
            }
        }else{
            char b = c.charAt(0);
            if (!Character.isLetterOrDigit(b)) {
                return false;
            }
        }
        return true;
    }

    private static int getPrecedence(String ch) {
        if (ch.equals("+") || ch.equals("-"))
            return 1;
        else if (ch.equals("*") || ch.equals("/"))
            return 2;
        else if (ch.equals("^"))
            return 3;
        else
            return -1;
    }
}