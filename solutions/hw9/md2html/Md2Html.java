package hw9.md2html;

import java.io.IOException;

public class Md2Html {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.Parse(args[0], args[1]);
    }
}
