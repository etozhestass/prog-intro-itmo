package hw5;

import java.io.*;
import java.nio.charset.Charset;

public class Scanner implements AutoCloseable {
    private final Reader in;
    private static final int BUFF_LEN = 256;
    private final char[] buffer = new char[BUFF_LEN];
    private int len;
    private int pos;
    private final String separator = System.lineSeparator();
    private boolean eof = false;


    private Scanner(Reader reader) {
        len = pos = 0;
        this.in = reader;
    }

    public Scanner(InputStream inputstream) throws IOException {
        this(new InputStreamReader(inputstream));
    }

    public Scanner(String str) throws IOException {
        this(new StringReader(str));
    }

    public Scanner(File file, Charset Charset) throws IOException {
        this(new InputStreamReader(new FileInputStream(file), Charset));
    }

    private enum Type {
        NUMBER, WORD, ABC, LINE
    }

    public boolean hasNextInt() throws IOException {
        return hasNextImpl(Type.NUMBER);
    }

    public boolean hasNextWord() throws IOException {
        return hasNextImpl(Type.WORD);
    }

    public boolean hasNextAbc() throws IOException {
        return hasNextImpl(Type.ABC);
    }

    public boolean hasNextLine() {
        return !eof;
    }

    private boolean hasNextImpl(Type type) throws IOException {
        reBuffer();
        while (!(isEofBuffer() || isSupportedWordByType(type))) {
            pos++;
            reBuffer();
        }
        return hasNextLine();
    }

    public String nextLine() throws IOException {
        return nextImpl(Type.LINE);
    }

    public String nextWord() throws IOException {
        return nextImpl(Type.WORD);
    }

    public String nextAbc() throws IOException {
        return nextImpl(Type.ABC);
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextImpl(Type.NUMBER));
    }

    private String nextImpl(Type type) throws IOException {
        reBuffer();
        if (type != Type.LINE) {
            hasNextImpl(type);
        }
        StringBuilder wordBuilder = new StringBuilder();
        while (!isEofBuffer() && isSupportedWordByType(type)) {
            wordBuilder.append(buffer[pos++]);
            reBuffer();
        }
        if (pos == len - 1) {
            readBuffer();
        } else {
            pos++;
        }
        return wordBuilder.toString();
    }

    private boolean isEofBuffer() {
        return pos > len;
    }

    private boolean isSupportedWordByType(Type type) {
        char ch = buffer[pos];
        return switch (type) {
            case NUMBER -> (ch == '-' || Character.isDigit(ch));
            case WORD -> Character.isLetter(ch) || ch == '\'' || Character.getType(ch) == Character.DASH_PUNCTUATION;
            case ABC -> ch == '-' || Character.isLetter(ch);
            case LINE -> !isLineSeparator();
        };
    }

    /*
     Instead of this we can use:
     return System.lineSeparator().charAt(System.lineSeparator().length() - 1) == buffer[pos];
     This method exists for cases, when System.lineSeparator() == '\n\n' for example.
     Actually, there is no OS where it's true. But we can imagine it
    */
    private boolean isLineSeparator() {
        int index = pos;
        while (!isEofBuffer() && index - pos < separator.length()) {
            if (buffer[index] != separator.charAt(index - pos)) {
                return false;
            }
            index++;
        }
        pos = index - 1;
        return true;
    }

    private void readBuffer() throws IOException {
        len = in.read(buffer);
        eof = len == -1;
        pos = 0;
    }

    private void reBuffer() throws IOException {
        if (pos == len) {
            readBuffer();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}