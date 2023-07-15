package hw12.parser;

import hw13.exceptions.errors.OverflowException;

import java.util.List;

public class BaseParser {
    private CharSource source;

    protected void setSource(CharSource source) {
        this.source = source;
    }

    protected IllegalArgumentException error(final String message) {
        return source.error(message);
    }

    public String getData() {
        return source.getData();
    }

    public int getPos() {
        return source.getPos();
    }

    public String getWord() {
        StringBuilder sb = new StringBuilder();
        source.skipWhitespace();
        while (source.hasNext() && Character.isLetter(source.curr())) {
            sb.append(next());
        }
        return sb.toString();
    }

    public String getToken(List<String> operationsBinary, List<String> operationsUnary) {
        StringBuilder sb = new StringBuilder();
        boolean operation = false;
        source.skipWhitespace();
        while (source.hasNext() && !Character.isWhitespace(source.curr()) && !operation) {
            if (operationsBinary.contains(String.valueOf(source.curr())) || operationsUnary.contains(String.valueOf(source.curr())) ||
                    source.curr() == '(' || between(source.curr(), 'x', 'z')) {
                operation = true;
                if (sb.length() > 0) {
                    break;
                }
            }
            sb.append(next());
        }
        return sb.toString();
    }

    protected boolean isEndOfString() {
        return !source.hasNext();
    }

    protected boolean hasNext() {
        return source.hasNext();
    }

    public char top() {
        source.skipWhitespace();
        return source.curr();
    }

    public char next() {
        return source.next();
    }

    public void skipWhitespace() {
        source.skipWhitespace();
    }

    public boolean isWhitespace() {
        return source.hasNext() && Character.isWhitespace(source.curr());
    }

    public int parseInt(boolean negate) {
        StringBuilder sb = new StringBuilder();
        if (negate) {
            sb.append('-');
        }
        sb.append(source.next());
        source.skipWhitespace();
        while (source.hasNext() && Character.isDigit(source.curr())) {
            sb.append(source.next());
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            throw new OverflowException(sb.toString());
        }
    }


    public boolean between(char x, char from, char to) {
        return from <= x && x <= to;
    }

    public boolean equals(char ch) {
        return top() == ch;
    }

    public boolean equals(char ch1, char ch2) {
        return top() == ch1 || top() == ch2;
    }
}