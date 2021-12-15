package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class EXR_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbers.push(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            numbers.pop();
        }
        if (numbers.contains(x)) {
            System.out.println("true");
        }else{
            if (numbers.isEmpty()) {
                System.out.println("0");
            }else{
                                    //getMaxElement(numbers) - option without Collection min/max functionality.
                System.out.println(Collections.min(numbers));
            }
        }

    }
/*    private static int getMaxElement(ArrayDeque<Integer> queue){
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int currentElement = queue.poll();

            if (currentElement > max) {
                max = currentElement;
            }
        }
        return max;
    }*/
}
