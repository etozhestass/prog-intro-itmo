package hw10.game;

//
//
//        HARD VERSION
//
//
//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Print m, n, k and how much time's you want to play");
        int m = in.nextInt(), n = in.nextInt(), k = in.nextInt(), z = in.nextInt();
        final Matches matches = new Matches(false, new HumanPlayer(), new HumanPlayer(), m, n, k, z);
        matches.start();
    }
}
