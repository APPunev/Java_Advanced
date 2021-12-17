package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class LAB_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().split("\\s++");
        }

        printFirstDiagonal(matrix);
        System.out.println();
        printSecondDiagonal(matrix);
    }

    private static void printSecondDiagonal(String[][] matrix) {
        for (int row = matrix.length - 1; row >=0 ; row--) {
            int cur = (matrix.length - 1) - row;
            System.out.print(matrix[row][cur] + " ");
        }
    }

    private static void printFirstDiagonal(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }

    }
}
