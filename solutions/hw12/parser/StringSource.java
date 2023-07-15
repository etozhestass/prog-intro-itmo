package hw12.parser;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class StringSource implements CharSource {
    private final String data;
    private int pos;

    public StringSource(final String data) {
        this.data = data;
    }

    public int getPos() {
        return pos;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public char next() throws IndexOutOfBoundsException {
        return data.charAt(pos++);
    }

    @Override
    public char curr() throws IndexOutOfBoundsException {
        return data.charAt(pos);
    }

    @Override
    public IllegalArgumentException error(final String message) {
        return new IllegalArgumentException(pos + ": " + message);
    }

    @Override
    public void skipWhitespace() {
        while (hasNext() && Character.isWhitespace(data.charAt(pos))) {
            pos++;
        }
    }
}
