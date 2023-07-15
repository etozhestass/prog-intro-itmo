package hw9.md2html;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Writer {
    BufferedWriter writer;

    Writer(String fileIn) throws FileNotFoundException {
        writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileIn),
                        StandardCharsets.UTF_8
                )
        );
    }
    void write(List<String> strings) throws IOException {
        for (String str : strings) {
            if (str.isEmpty()) continue;
            writer.write(str);
            writer.newLine();
        }
        writer.close();
    }
}
