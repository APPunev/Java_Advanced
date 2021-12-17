package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LAB_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> expression = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {

            if (input.charAt(index) == '(') {
                expression.push(index);
            } else if (input.charAt(index) == ')') {
                int startIndex = expression.pop();
                String content = input.substring(startIndex, index + 1);
                System.out.println(content);
            }
        }
    }
}
