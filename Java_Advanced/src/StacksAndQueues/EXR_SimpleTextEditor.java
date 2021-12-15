package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EXR_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder builder = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] token = input.split("\\s+");
            String command = token[0];

            switch (command){
                case "1":
                    String arr = token[1];
                    if (builder.length() != 0) {
                        stack.push(builder.toString());
                    }else{
                        stack.push(" ");
                    }
                    builder.append(arr);
                    break;
                case "2":
                    if (builder.length() != 0) {
                        stack.push(builder.toString());
                    }else{
                        stack.push(" ");
                    }
                    int elementsDlt = Integer.parseInt(token[1]);
                    int startIndex = builder.length() - elementsDlt;
                    int endIndex = builder.length();
                    builder.delete(startIndex,endIndex);
                    break;
                case "3":
                    int index = Integer.parseInt(token[1]);
                    System.out.println(builder.charAt(index - 1));
                    break;
                case "4":
                    if (stack.isEmpty()) {
                        builder = new StringBuilder("");
                    }else{
                        if (stack.peek().equals(" ")) {
                            builder = new StringBuilder("");
                            stack.pop();
                        }else{
                            builder = new StringBuilder(stack.pop());
                        }
                    }
                    break;
            }
        }
    }
}
