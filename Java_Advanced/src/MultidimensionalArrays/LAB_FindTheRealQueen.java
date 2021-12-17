package MultidimensionalArrays;

import java.util.Scanner;

public class LAB_FindTheRealQueen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];
        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().split("\\s++");
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String current = matrix[row][col];

                if (current.equals("q") && queenIsValid(matrix,row,col)) {
                    System.out.println(row + " " + col);
                }
            }
        }
    }

    private static boolean queenIsValid(String[][] matrix, int row, int col) {
        for (int rowDirection = -1; rowDirection <= 1 ; rowDirection++) {
            for (int colDirection = -1; colDirection <=1 ; colDirection++) {

                if (rowDirection == 0 && colDirection == 0) {
                    continue;
                }
                int currentRow = row + rowDirection;
                int currentCol = col + colDirection;

                boolean validPosition = isValidPosition(matrix,currentRow,currentCol);

                while (validPosition) {
                    String currentElement = matrix[currentRow][currentCol];
                    if (currentElement.equals("q")) {
                        return false;
                    }
                    currentRow = currentRow + rowDirection;
                    currentCol = currentCol + colDirection;
                    validPosition = isValidPosition(matrix,currentRow,currentCol);
                }
            }
        }
        return true;
    }

    public static boolean isValidPosition (String[][]matrix, int row, int col){
        return row >= 0
                && row < matrix.length
                && col >= 0
                && col < matrix[row].length;
    }

    public static void printMatrix(String[][] matrix){
        for (String[]arr:matrix) {
            for (String el:arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
