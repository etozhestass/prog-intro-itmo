package hw8;

import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        double a = in.nextInt();
        double b = in.nextInt();
        double n = in.nextInt();
        int result = (int) (2 * (Math.ceil((n - b) / (b - a))) + 1);
        System.out.print(result);
    }
}
