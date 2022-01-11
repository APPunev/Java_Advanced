package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EXR_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] tokens = scanner.nextLine().split(" ");

        int[] plants = new int[n];

        for (int i = 0; i < n; i++) {
            plants[i] = Integer.parseInt(tokens[i]);
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(0);

        int[] days = new int[n];
        for (int i = 1; i < n; i++) {
            int maxDays = 0;
            while (!stack.isEmpty() && plants[stack.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[stack.pop()]);
            }
            if (!stack.isEmpty()) {
                days[i] = maxDays + 1;
            }
            stack.push(i);
        }
        System.out.println(getLastDay(days));
    }

    private static int getLastDay(int[] days) {
        int lastDay = 0;
        for (int day : days) {
            if (day > lastDay) {
                lastDay = day;
            }
        }
        return lastDay;
    }
}
