package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LAB_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(n,0, scanner);
        
        int[] coordinates = readArray(scanner.nextLine());
        
        int wrongValues = matrix[coordinates[0]][coordinates[1]];

        List<int[]> updatedValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col]== wrongValues) {
                    updatedValues.add(new int[]{row,col, getClosestItemSum(row,col,matrix, wrongValues)});
                }
            }
        }

        for (int[] updated:updatedValues) {
            matrix[updated[0]][updated[1]] = updated[2];
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[]arr:matrix) {
            for (int el:arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    private static int getClosestItemSum(int row, int col, int[][] matrix, int wrongValue) {
        int sum = 0;

        if (isInBounds(row,col + 1,matrix) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];// right
        }
        if (isInBounds(row,col - 1,matrix) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];//left
        }
        if (isInBounds(row + 1,col,matrix) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];//down
        }
        if (isInBounds(row - 1,col,matrix) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];//up
        }
        return sum;
    }

    public static boolean isInBounds(int row, int col, int[][] matrix){
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[][] readMatrix(int row, int col, Scanner scanner) {
        int [][]matrix = new int[row][col];

        for (int rows = 0; rows < row; rows++) {
            matrix[rows] = readArray(scanner.nextLine());
        }

        return matrix;
    }

    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
