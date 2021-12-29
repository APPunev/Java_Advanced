package MultidimensionalArrays;

import java.util.Scanner;

public class EXR_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String command = input[1];

        int[][] matrix = new int[size][];
        if (command.equals("A")) {
            matrix = fillMatrixA(size);

        }else if (command.equals("B")){
            matrix = fillMatrixB(size);
        }else{
            matrix = fillMatrixC(size);
        }

        printMatrix(matrix);
    }

    private static int[][] fillMatrixC(int size) {
        int [][] matrix = new int[size][size];
        int counter = 1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = counter++;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixB(int size) {
        int [][] matrix = new int[size][size];
        int counter = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter++;
                }
            }else{
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixA(int size) {
        int [][] matrix = new int[size][size];
        int counter = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter++;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][]matrix){
        for (int[]arr:matrix) {
            for (int el:arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
