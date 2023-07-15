package hw3;

import java.io.IOException;
import java.util.Arrays;
import hw5.Scanner;

public class Reverse {
    public static void main(String[] args) {
        final int startSize = 16;
        int[][] matrix = new int[startSize][startSize];
        int[] ends = new int[startSize];
        int column = 0;
        try (Scanner scan = new Scanner(System.in)) {
            int lenColumn;
            int lenRow;
            int countOnRow;
            while (scan.hasNextLine()) {
                Scanner scanString = new Scanner(scan.nextLine());
                countOnRow = 0;
                lenColumn = matrix.length;
                if (column >= lenColumn) {
                    matrix = Arrays.copyOf(matrix, column * 2);
                    ends = Arrays.copyOf(ends, column * 2);
                    for (int fill = column; fill < matrix.length; fill++) {
                        matrix[fill] = new int[startSize];
                    }
                }

                while (scanString.hasNextInt()) {
                    lenRow = matrix[column].length;
                    if (countOnRow >= lenRow) {
                        matrix[column] = Arrays.copyOf(matrix[column], lenRow * 2);
                    }
                    matrix[column][countOnRow++] = scanString.nextInt();
                }
                ends[column++] = countOnRow - 1;
                scanString.close();
            }
        } catch (IOException e) {
            System.out.println("Problem with IO");
        }
        for (--column; column >= 0; --column) {
            for (int end = ends[column]; end >= 0; --end) {
                System.out.print(Integer.toString(matrix[column][end]) + ' ');
            }
            System.out.println();
        }
    }
}