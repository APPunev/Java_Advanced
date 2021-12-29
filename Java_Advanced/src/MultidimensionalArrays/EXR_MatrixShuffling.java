package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class EXR_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rawAndCol = readArray(scanner.nextLine());

        int rows = rawAndCol[0];
        int cols = rawAndCol[1];

        String[][] matrix = readMatrix(rows,cols,scanner);

        String command = scanner.nextLine();
        while(!command.equals("END")){

            if (commandIsValid(command,matrix)) {
                printMatrix(matrix);
            }else{
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
    }

    public static boolean commandIsValid(String command, String[][] matrix){
        String[] token = command.split("\\s+");
        if (token.length != 5) {
            return false;
        }
        if (!token[0].equals("swap")) {
            return false;
        }
        try{
            int row1 = Integer.parseInt(command.split("\\s+")[1]);
            int col1 = Integer.parseInt(command.split("\\s+")[2]);
            int row2 = Integer.parseInt(command.split("\\s+")[3]);
            int col2 = Integer.parseInt(command.split("\\s+")[4]);

            if (!indexIsValid(row1,col1, matrix) && !indexIsValid(row2,col2, matrix)) {
                return false;
            }

            String current = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = current;
        }catch (NumberFormatException a){
            return false;
        }


        return true;
    }

    private static boolean indexIsValid(int row, int col, String[][]matrix) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) {
            return true;
        }
        return false;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[]arr:matrix) {
            for (String el:arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(int rows, int cols, Scanner scanner) {
        String[][]matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
