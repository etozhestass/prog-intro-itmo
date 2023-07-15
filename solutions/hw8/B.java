package hw8;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            for (int i = -710 * 25000; n > 0; i += 710) {
                System.out.println(i);
                --n;
            }
        }
    }
}
