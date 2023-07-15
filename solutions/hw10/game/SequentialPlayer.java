package hw10.game;

public class SequentialPlayer implements Player {

    private final int m;
    private final int n;

    SequentialPlayer(int m, int n) {

        this.m = m;
        this.n = n;
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        for (int r = 0; r < m + 1; r++) {
            for (int c = 0; c < n + 1; c++) {
                final Move move = new Move(r, c, cell);
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new IllegalStateException("No valid moves");
    }
}
