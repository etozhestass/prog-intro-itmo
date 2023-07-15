package hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            a[i] = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();

        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i][j] != 0) {
                    a[i][j] = 1;
                    for (int z = j + 1; z < n; z++) {
                        a[i][z] = (a[i][z] - a[j][z]) % 10;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
