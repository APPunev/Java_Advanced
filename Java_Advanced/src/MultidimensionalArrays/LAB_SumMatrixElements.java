package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class LAB_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(rows,cols,scanner);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(calculateSum(matrix));
    }

    private static int calculateSum(int[][] matrix) {
        return Arrays.stream(matrix)
                .flatMapToInt(arr-> Arrays.stream(arr))
                .sum();
    }

    public static int[] readArray(String line, String pattern){
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner){
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(),", ");
        }

        return matrix;
    }
}
