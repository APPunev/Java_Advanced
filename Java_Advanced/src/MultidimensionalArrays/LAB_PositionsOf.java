package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LAB_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int [][] matrix = readMatrix(rows,cols,scanner);

        int n = Integer.parseInt(scanner.nextLine());

        List<int []> output = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == n) {
                    output.add(new int[]{row,col});
                }
            }
        }

        if (output.isEmpty()) {
            System.out.println("not found");
        }else{
            for (int[] index:output) {
                System.out.println(index[0] + " " + index[1]);
            }
        }
    }


    public static int[][] readMatrix(int rows, int cols, Scanner scanner){
        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine());
        }
        return matrix;
    }

    private static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
