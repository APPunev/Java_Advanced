package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class LAB_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstArr = readMatrix(rows,cols,scanner);
        String[][] secondArr = readMatrix(rows,cols,scanner);

        String[][] resultMatrix = fillMatrix(firstArr,secondArr, rows, cols);



        printMatrix(resultMatrix);

    }

    private static String[][] readMatrix(int rows, int cols,Scanner scanner) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s++");
        }

        return matrix;
    }

    public static String[][] fillMatrix(String[][] first,String[][] second, int rows, int cols){

        String[][] output = new String[rows][cols];

        for (int row = 0; row < first.length; row++) {
            String[] currentFirst = first[row];
            String[] currentSecond = second[row];
            for (int col = 0; col < currentFirst.length ; col++) {
                String strFirst = currentFirst[col];
                String strSecond = currentSecond[col];

                if (strFirst.equals(strSecond)) {
                    output[row][col] = first[row][col];
                }else{
                    output[row][col] = "*";
                }
            }
        }

        return output;
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
//a b c d
//a b c d
//a b c d

//k b c k
//a b g d
//a k c d

//* b c *
//a b * d
//a * c d