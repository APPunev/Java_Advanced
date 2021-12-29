package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class EXR_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowAndCol = readArray(scanner.nextLine());

        int rows = rowAndCol[0];
        int cols = rowAndCol[1];

        String[][] matrix = readMatrix(rows,cols);

        printMatrix(matrix);

    }

    private static String[][] readMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        char firstChar = 97;
        char lastChar = 97;
        char middleChar = 97;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = firstChar + "" + middleChar + lastChar;
                middleChar++;
            }
            firstChar++;
            middleChar = firstChar;
            lastChar++;
        }

        return matrix;
    }

    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void printMatrix(String[][]matrix){
        for (String[]arr:matrix) {
            for (String el:arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
