package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;


public class LAB_MathPotato {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int toss = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name : names) {
            queue.offer(name);
        }

        int cycle = 1;
        while(queue.size() > 1){
            for (int i = 1; i < toss; i++) {
                String current = queue.poll();
                queue.offer(current);
            }

            if (!isNotPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycle++;

        }
        System.out.println("Last is " + queue.poll());
    }

    public static boolean isNotPrime(int n){
        boolean isNotPrime = false;
        if (n == 1 || n == 0) {
            isNotPrime = true;
            return isNotPrime;
        }else{
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isNotPrime = true;
                    return isNotPrime;
                }
            }
        }
        return isNotPrime;
    }
}
