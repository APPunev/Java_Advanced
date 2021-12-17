package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class LAB_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowAndCollFirst = readArray(scanner.nextLine());

        int rows = rowAndCollFirst[0];
        int cols = rowAndCollFirst[1];

        int[][] firstMatrix = readMatrix(rows,cols, scanner);

        rowAndCollFirst = readArray(scanner.nextLine());

        rows = rowAndCollFirst[0];
        cols = rowAndCollFirst[1];

        int [][] secondMatrix = readMatrix(rows,cols, scanner);

        if (matricesAreEqual(firstMatrix,secondMatrix)) {
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    private static boolean matricesAreEqual(int[][] first, int[][] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int row = 0; row < first.length; row++) {
            int[] firstArr = first[row];
            int[] secondArr = second[row];

            if (secondArr.length != firstArr.length) {
                return false;
            }

            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secondArr[col]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static int[][] readMatrix(int rows, int cols, Scanner scanner){
        int [][]matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine());
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        for (int[] arr:matrix) {
            for (int element:arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

