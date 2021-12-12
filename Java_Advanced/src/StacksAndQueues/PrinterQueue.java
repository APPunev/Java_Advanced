package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while(!input.equals("print")){
            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                }else{
                    String current = queue.poll();
                    System.out.println("Canceled " + current);
                }
            }else{
                queue.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String s : queue) {
            System.out.println(s);
        }

    }
}
