package hw10.game;

public interface Board {
    Position getPosition();

    Cell getCell();

    Result makeMove(Move move);
}
