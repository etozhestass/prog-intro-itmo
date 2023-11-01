package hw5;

import java.io.IOException;
import java.util.Arrays;

public class ReverseAbc {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            long[][] matrix = new long[1][1];
            int[] ends = new int[1];
            int column = 0;
            while (scan.hasNextLine()) {
                Scanner scanString = new Scanner(scan.nextLine());
                int count = 0, lenColumn = matrix.length;

                if (column >= lenColumn) {
                    matrix = Arrays.copyOf(matrix, column * 2);
                    ends = Arrays.copyOf(ends, column * 2);
                    for (int fill = column; fill < matrix.length; fill++) {
                        matrix[fill] = new long[1];
                    }
                }

                while (scanString.hasNextAbc()) {
                    int lenRow = matrix[column].length;
                    if (count >= lenRow) {
                        matrix[column] = Arrays.copyOf(matrix[column], lenRow * 2);
                    }
                    matrix[column][count] = parseAbc(scanString.nextAbc());
                    count++;
                }
                ends[column] = count;
                column++;
                scanString.close();
            }
            for (--column; column >= 0; --column) {
                for (int end = ends[column] - 1; end >= 0; --end) {
                    System.out.print(toAbc(matrix[column][end]) + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Problem with IO" + e.getMessage());
        }
    }

    private static long parseAbc(String word) {
        int pow = 1;
        long res = 0;
        char[] wordToCharArray = word.toCharArray();
        int len = wordToCharArray.length;
        for (int i = len - 1; i >= 0; i--) {
            char token = wordToCharArray[i];
            if (token == '-') {
                continue;
            }
            res += (long) (wordToCharArray[i] - 'a') * pow;
            pow *= 10;
        }
        if (word.charAt(0) == '-') {
            res *= -1;
        }
        return res;
    }

    private static String toAbc(long number) {
        StringBuilder stringBuilder = new StringBuilder();
        long originNumber = number;
        do {
            long digit = number % 10;
            char letter = (char) ('a' + Math.abs(digit));
            stringBuilder.append(letter);
            number /= 10;
        } while (number != 0);

        if (originNumber < 0) {
            stringBuilder.append('-');
        }
        return stringBuilder.reverse().toString();
    }
}