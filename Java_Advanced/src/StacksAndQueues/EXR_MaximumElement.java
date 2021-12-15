package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class EXR_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> num = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String[] token = command.split("\\s+");
            switch (token[0]){
                case "2":
                    num.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(num));
                    break;
                case "1":
                    int push = Integer.parseInt(token[1]);
                    num.push(push);
                    break;
            }
        }
    }
}
