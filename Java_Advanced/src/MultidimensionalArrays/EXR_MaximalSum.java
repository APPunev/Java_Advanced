package MultidimensionalArrays;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class EXR_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowAndCol = readArray(scanner.nextLine());

        int rows = rowAndCol[0];
        int cols = rowAndCol[1];

        int[][]matrix = readMatrix(rows,cols, scanner);

        int maxSum = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int curRow = 0; curRow < matrix.length - 2; curRow++) {
            for (int curCol = 0; curCol < matrix[0].length - 2; curCol++) {
                int sum = 0;
                sum += matrix[curRow][curCol] + matrix[curRow][curCol+1] + matrix[curRow][curCol+2];
                sum += matrix[curRow+1][curCol] + matrix[curRow+1][curCol+1] + matrix[curRow+1][curCol+2];
                sum += matrix[curRow+2][curCol] + matrix[curRow+2][curCol+1] + matrix[curRow+2][curCol+2];

                if (sum > maxSum){
                    maxSum = sum;
                    row = curRow;
                    col = curCol;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static int[][] readMatrix(int row, int col, Scanner scanner) {
        int [][]matrix = new int[row][col];

        for (int rows = 0; rows < row; rows++) {
            matrix[rows] = readArray(scanner.nextLine());
        }

        return matrix;
    }

    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
