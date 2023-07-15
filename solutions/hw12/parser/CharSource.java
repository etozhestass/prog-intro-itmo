package hw12.parser;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface CharSource {
    boolean hasNext();
    char next();

    char curr();
    String getData();
    int getPos();

    IllegalArgumentException error(String message);

    void skipWhitespace();
}
