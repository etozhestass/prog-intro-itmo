package hw5;

import java.io.IOException;
import java.util.Arrays;

public class ReverseAbc {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String[][] matrix = new String[1][1];
            int[] ends = new int[1];
            int column = 0;
            while (scan.hasNextLine()) {
                Scanner scanString = new Scanner(scan.nextLine());
                int count = 0, lenColumn = matrix.length;

                if (column >= lenColumn) {
                    matrix = Arrays.copyOf(matrix, column * 2);
                    ends = Arrays.copyOf(ends, column * 2);
                    for (int fill = column; fill < matrix.length; fill++) {
                        matrix[fill] = new String[1];
                    }
                }

                while (scanString.hasNextAbc()) {
                    int lenRow = matrix[column].length;
                    if (count >= lenRow) {
                        matrix[column] = Arrays.copyOf(matrix[column], lenRow * 2);
                    }
                    matrix[column][count] = scanString.nextAbc();
                    count++;
                }
                ends[column] = count;
                column++;
                scanString.close();
            }
            for (--column; column >= 0; --column) {
                for (int end = ends[column] - 1; end >= 0; --end) {
                    System.out.print(matrix[column][end] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Problem with IO" + e.getMessage());
        }
    }
}