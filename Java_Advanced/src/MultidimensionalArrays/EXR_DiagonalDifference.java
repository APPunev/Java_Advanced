package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class EXR_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());;

        int[][] matrix = readMatrix(size, scanner);

        int primaryDiagonal = primaryDiagonalSum(matrix);
        int secondaryDiagonal = secondaryDiagonalSum(matrix);

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int [][]matrix = new int[size][size];

        for (int rows = 0; rows < size; rows++) {
            matrix[rows] = readArray(scanner.nextLine());
        }

        return matrix;
    }

    private static int secondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    private static int primaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }


        return sum;
    }

    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
