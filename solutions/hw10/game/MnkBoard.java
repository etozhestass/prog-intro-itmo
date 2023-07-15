package hw10.game;

//
//
//        HARD VERSION
//
//
//


import java.util.Arrays;
import java.util.Map;

public class MnkBoard implements Board, Position {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );
    private final Cell[][] cells;
    private Cell turn;

    private final int m, n, k;
    private int countMoves;

    public MnkBoard(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.cells = new Cell[m][n];
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        this.turn = Cell.X;
        this.countMoves = 0;
    }

    @Override
    public Position getPosition() {
        MnkBoard newBoard = new MnkBoard(this.m, this.n, this.k);
        for (int i = 0; i < m; i++) {
            if (n >= 0) {
                System.arraycopy(this.cells[i], 0, newBoard.cells[i], 0, n);
            }
        }
        newBoard.turn = this.turn;
        newBoard.countMoves = this.countMoves;
        return newBoard;
    }

    @Override
    public Cell getCell() {
        return turn;
    }

    private boolean isContains(int x, int y) {
        return (0 <= x && x < cells.length && 0 <= y && y < cells[0].length && cells[x][y] == turn);
    }

    @Override
    public Result makeMove(final Move move) {
        boolean bonus = false;

        if (!isValid(move)) {
            return Result.LOSE;
        }
        countMoves++;

        int row = move.getRow(), col = move.getColumn();

        cells[row][col] = move.getValue();

        int count, i;

        int[] dx = new int[]{0, 1, 1, -1};
        int[] dy = new int[]{1, 0, 1, 1};

        for (int j = 0; j < 4; j++) {
            count = 1;
            i = 1;
            if (count == k) {
                return Result.WIN;
            }
            while (isContains(row + dx[j] * i, col + dy[j] * i) ||
                    isContains(row - dx[j] * i, col - dy[j] * i)
            ) {
                if (isContains(row + dx[j] * i, col + dy[j] * i) &&
                        isContains(row - dx[j] * i, col - dy[j] * i)
                ) {
                    count++;
                }
                i++;
                if (++count >= k) {
                    System.out.println("Position");
                    System.out.println(getPosition());
                    return Result.WIN;
                }
                if (count >= 4) {
                    bonus = true;
                }
            }
        }
        if (countMoves == (m * n)) {
            return Result.DRAW;
        }

        if (bonus) {
            return Result.Four;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;
        return Result.UNKNOWN;
    }

    @Override
    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < m
                && 0 <= move.getColumn() && move.getColumn() < n
                && cells[move.getRow()][move.getColumn()] == Cell.E
                && turn == getCell();
    }

    @Override
    public Cell getCell(final int r, final int c) {
        return cells[r][c];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        for (int c = 1; c < n + 1; c++) {
            sb.append(c);
        }
        for (int r = 0; r < m; r++) {
            sb.append("\n");
            sb.append(r + 1);
            for (int c = 0; c < n; c++) {
                sb.append(SYMBOLS.get(cells[r][c]));
            }
        }
        return sb.toString();
    }
}
