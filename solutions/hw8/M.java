package hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class M {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));


    static int tokenInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        int result;
        int t = tokenInt();
        for (int i = 0; i < t; i++) {
            result = 0;
            int n = tokenInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = tokenInt();
            }
            Map<Integer, Integer> m = new HashMap<>();
            for (int j = n - 2; j > 0; --j) {
                m.put(a[j + 1], m.getOrDefault(a[j + 1], 0) + 1);
                for (int l = 0; l < j; l++) {
                    int k = 2 * a[j] - a[l];
                    if (m.containsKey(k)) {
                        result += m.get(k);
                    }
                }
            }
            System.out.println(result);
        }
    }
}