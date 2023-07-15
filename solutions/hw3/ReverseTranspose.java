package hw3;

import java.io.IOException;
import java.util.Arrays;
import hw5.Scanner;

import static java.lang.Math.max;

public class ReverseTranspose {
    public static void main(String[] args) {
        final int startSize = 16;
        int[][] matrix = new int[startSize][startSize];
        int[] lengthsRow = new int[startSize];
        int countColumn = 0;
        int maxSizeRow = 0;
        try (Scanner scan = new Scanner(System.in)) {
            int countOnRow;
            int lenRow;
            int lenColumn;
            while (scan.hasNextLine()) {
                Scanner scanString = new Scanner(scan.nextLine());
                countOnRow = 0;
                lenColumn = matrix.length;
                if (countColumn >= lenColumn) {
                    matrix = Arrays.copyOf(matrix, countColumn * 2);
                    lengthsRow = Arrays.copyOf(lengthsRow, countColumn * 2);
                    for (int fill = countColumn; fill < matrix.length; fill++) {
                        matrix[fill] = new int[startSize];
                    }
                }
                while (scanString.hasNextInt()) {
                    lenRow = matrix[countColumn].length;
                    if (countOnRow >= lenRow) {
                        matrix[countColumn] = Arrays.copyOf(matrix[countColumn], lenRow * 2);
                    }
                    matrix[countColumn][countOnRow++] = scanString.nextInt();
                }
                maxSizeRow = max(maxSizeRow, countOnRow);
                lengthsRow[countColumn++] = countOnRow;
                scanString.close();
            }
        } catch (IOException e) {
            System.out.print("Problem with Input Data");
        }
        for (int i = 0; i < maxSizeRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                if (i < lengthsRow[j]) {
                    System.out.print(Integer.toString(matrix[j][i]) + ' ');
                }
            }
            System.out.println();
        }
    }
}