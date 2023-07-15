package hw9.md2html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Parser {
    private final List<String> strings = new ArrayList<>();
    private final StringBuilder stringBuilder = new StringBuilder();
    private final Map<String, Pairs> htmlTag = Map.of(
            "*", new Pairs("em>"),
            "_", new Pairs("em>"),
            "**", new Pairs("strong>"),
            "__", new Pairs("strong>"),
            "--", new Pairs("s>"),
            "`", new Pairs("code>"),
            "++", new Pairs("u>")
    );
    private static final Map<String, String> specialSymbol = Map.of(
            "<", "&lt;",
            ">", "&gt;",
            "&", "&amp;"
    );

    public void makeTag(int lvl, String prefix) {
        stringBuilder.append(prefix);
        if (lvl > 0) {
            stringBuilder.append("h").append(lvl).append('>');
        } else {
            stringBuilder.append("p>");
        }
    }

    public void Parse(String fileIn, String fileOut) throws IOException {
        int lvl = 0;

        Reader reader = new Reader(fileIn);
        reader.read(strings);

        for (int i = 0; i < strings.size(); i++) {
            stringBuilder.setLength(0);
            String str = strings.get(i);
            boolean isStart = isParagraph(i);
            if (str.isEmpty()) {
                continue;
            } else if (isStart) {
                lvl = level(str);
                makeTag(lvl, "<");
                counter(i);
            }
            int index = 0;
            if (lvl != 0 && isStart) {
                index = lvl + 1;
            }
            ParseString(stringBuilder, str.substring(index));
            if (isEndParagraph(i)) {
                makeTag(lvl, "</");
            }
            strings.set(i, stringBuilder.toString());
        }
        Writer writer = new Writer(fileOut);
        writer.write(strings);
    }

    private void ParseString(StringBuilder stringBuilder, String str) {
        int len = str.length();
        int lenTag;
        for (int i = 0; i < len; i++) {
            lenTag = i + 1;
            if (i < str.length() - 1 && htmlTag.containsKey(str.substring(i, i + 2))) {
                lenTag++;
            }
            String substring = str.substring(i, lenTag);
            i += substring.length() - 1;
            Pairs pairs = htmlTag.get(substring);
            if (htmlTag.containsKey(substring) && pairs.getCount() > 1) {
                pairs.minusCount();
                stringBuilder.append('<');
                if (pairs.getCount() % 2 == 1) {
                    stringBuilder.append('/');
                }
                stringBuilder.append(pairs.getStr());
            } else if (substring.equals("\\") && i < len - 1) {
                stringBuilder.append(str.charAt(++i));
            } else {
                stringBuilder.append(specialSymbol.getOrDefault(substring, substring));
            }
        }
    }

    private void counter(int j) {
        for (String string : htmlTag.keySet()) {
            htmlTag.get(string).zeroCount();
        }
        while (j < strings.size()) {
            count(strings.get(j));
            if (isEndParagraph(j++)) {
                break;
            }
        }
        for (String tag : htmlTag.keySet()) {
            if (htmlTag.get(tag).getCount() % 2 == 0) {
                htmlTag.get(tag).plusCount();
            }
        }
    }

    void count(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int index = i + 1;
            if (i < str.length() - 1 && (htmlTag.containsKey(str.substring(i, i + 2)) || str.charAt(i) == '\\')) {
                index++;
            }
            String substring = str.substring(i, index);
            i += substring.length() - 1;
            if (htmlTag.containsKey(substring)) {
                htmlTag.get(substring).plusCount();
            }
        }
    }

    private int level(String str) {
        int lvl = 0;
        if (str.isEmpty()) return -1;
        while (str.charAt(lvl) == '#' && lvl < 6) {
            lvl++;
        }
        if (Character.isWhitespace(str.charAt(lvl))) {
            return lvl;
        }
        return 0;
    }

    private boolean isParagraph(int i) {
        return i == -1 || i == 0 || strings.get(i - 1).isEmpty();
    }

    private boolean isEndParagraph(int i) {
        return i == strings.size() - 1 || strings.get(i + 1).isEmpty();
    }
}
