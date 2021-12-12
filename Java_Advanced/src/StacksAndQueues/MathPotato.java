package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;


public class MathPotato {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int toss = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name : names) {
            queue.offer(name);
        }
        //10 Toss
        //George Peter Misha Sara Kendal = 10/5 = 2 cycles
        //George Peter Misha Sara = 10/4 = 2.5 cycles (3)
        //George Peter Misha = 10/3 = 3.3 (4)
        //George Peter = 10/2 = 5
        int cycle = 1;
        while(queue.size() > 1){
            for (int i = 1; i < toss; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            }else{
                System.out.println("Removed " + queue.poll());
            }
            cycle++;

        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int n) {
        boolean primeCheck = true;
        if (n == 0 || n == 1) {
            primeCheck = false;
            return primeCheck;
        }else{
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    primeCheck = false;
                }
            }
            return primeCheck;
        }
    }
}
