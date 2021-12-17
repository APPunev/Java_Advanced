package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LAB_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int toss = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name:names) {
            queue.offer(name);
        }
        while(queue.size() > 1){
            for (int i = 1; i < toss; i++) {
                String current = queue.poll();
                queue.offer(current);
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());

    }
}
