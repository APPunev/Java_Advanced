package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binary = new ArrayDeque<>();

        int decimal = Integer.parseInt(scanner.nextLine());

        if (decimal == 0) {
            System.out.println("0");
        }else{
            while(decimal != 0){
                binary.push(decimal % 2);
                decimal /= 2;
            }
        }
        binary.forEach(e -> System.out.print(binary.pop()));
    }
}
