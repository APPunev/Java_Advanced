package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EXR_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        boolean areBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                openBrackets.push(current);
            }else if (current == ')' || current == ']' || current == '}') {
                if (openBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpen = openBrackets.pop();
                if (lastOpen == '(' && current == ')') {
                    areBalanced = true;
                }else if (lastOpen == '[' && current == ']') {
                    areBalanced = true;
                }else if (lastOpen == '{' && current == '}') {
                    areBalanced = true;
                }else{
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
