package hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class I {

    static StreamTokenizer in;

    static int tokenInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        int n = tokenInt();

        int xl = Integer.MAX_VALUE, xr = Integer.MIN_VALUE, yl = Integer.MAX_VALUE, yr = Integer.MIN_VALUE;
        int x = 0, y = 0, h = 0;

        for (int i = 0; i < n; i++) {
            int xi = tokenInt(), yi = tokenInt(), hi = tokenInt();

            xl = Math.min(xi - hi, xl);
            xr = Math.max(xi + hi, xr);

            yl = Math.min(yi - hi, yl);
            yr = Math.max(yi + hi, yr);

            h = (Math.max(xr - xl + 1, yr - yl + 1) / 2);
            x = (xl + xr) / 2;
            y = (yl + yr) / 2;
        }

        System.out.println(x + " " + y + " " + h);

    }
}
