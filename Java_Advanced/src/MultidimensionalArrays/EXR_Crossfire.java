package MultidimensionalArrays;

import java.util.Scanner;

import static MultidimensionalArrays.Demo.*;

public class EXR_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowAndCol = readArray(scanner.nextLine());

        int rows = rowAndCol[0];
        int cols = rowAndCol[1];

        String[][]matrix = readMatrix(rows,cols);

        String inputCommand = scanner.nextLine();

        while(!inputCommand.equals("Nuke it from orbit")){
            String[] command = inputCommand.split("\\s+");
            int row = Integer.parseInt(command[0]);
            int col = Integer.parseInt(command[1]);
            int radius = Integer.parseInt(command[2]);

            if (coordinatesAreValid(row,col,matrix)) {
                nukeCoordinates(matrix,row,col,radius);
            }
            inputCommand = scanner.nextLine();
        }

        printMatrix(matrix);
    }
// 1  2  3  4  5
// 6  7  8  9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25

    private static void printMatrix(String[][]matrix){
        for (String[]arr:matrix) {
            for (String el:arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    private static void nukeCoordinates(String[][] matrix, int row, int col, int radius) {
        matrix[row][col] = "";
        int counter = 1;
        for (int i = 0; i < radius; i++) {
            if (isValidPosition(row,col + counter,matrix)) {
                matrix[row][col + counter] = "";// right
            }
            if (isValidPosition(row,col - counter,matrix)) {
                matrix[row][col - counter] = "";//left
            }
            if (isValidPosition(row + counter,col,matrix)) {
                matrix[row + counter][col] = "";//down
            }
            if (isValidPosition(row - counter,col,matrix)) {
                matrix[row - counter][col] = "";//up
            }
            counter++;
        }
    }

    private static boolean isValidPosition(int rowR, int colC,String[][] matrixM) {
        return rowR >= 0
                && rowR < matrixM.length
                && colC >= 0
                && colC < matrixM[rowR].length;
    }

    private static boolean coordinatesAreValid(int r, int c, String[][] m) {
        return r >= 0 && r < m.length && c >= 0 && c < m[r].length;
    }

    private static String[][] readMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(counter++);
            }
        }
        return matrix;
    }
}
