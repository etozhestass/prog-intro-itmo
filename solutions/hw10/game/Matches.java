package hw10.game;

public class Matches {
    private final boolean log;
    private final Player player1;
    private final Player player2;
    private final int m;
    private final int n;
    private final int k;
    private final int z;

    Matches(boolean log, Player player1, Player player2, int m, int n, int k, int z) {
        this.log = log;
        this.player1 = player1;
        this.player2 = player2;
        this.m = m;
        this.n = n;
        this.k = k;
        this.z = z;
    }

    public void start() {
        int firstCount = 0, secondCount = 0;
        for (int i = 0; i < z; i++) {
            Player playerFirst = i % 2 == 0 ? player1 : player2;
            Player playerSecond = i % 2 == 0 ? player2 : player1;
            Game game = new Game(log, playerFirst, playerSecond);
            int result;
            result = game.play(new MnkBoard(m, n, k));
            if (result == 1) {
                if (i % 2 == 0) {
                    System.out.println("First Player won");
                    firstCount++;
                } else {
                    System.out.println("Second Player won");
                    secondCount++;
                }
            } else if (result == 2) {
                if (i % 2 == 0) {
                    System.out.println("Second Player won");
                    secondCount++;
                } else {
                    System.out.println("First Player won");
                    firstCount++;
                }
            } else {
                i--;
                System.out.println("It's draw");
            }
            //System.out.println("Game result: " + result);
        }
        System.out.println("final score: first player - " + firstCount + " second player - " + secondCount);
    }
}
