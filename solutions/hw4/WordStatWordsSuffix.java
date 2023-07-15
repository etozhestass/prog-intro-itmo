package hw4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class WordStatWordsSuffix {
    private static boolean isSupportedSymbol(String str, int i) {
        char chr = str.charAt(i);
        return Character.isLetter(chr) ||
                Character.getType(chr) == Character.DASH_PUNCTUATION ||
                chr == '\'';
    }

    private static int getIndexWordEnd(String str, int index) {
        while (index < str.length() && isSupportedSymbol(str, index)) {
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        Map<String, Integer> dictionary = new TreeMap<>();
        try (BufferedReader fileIn = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(args[0]),
                        StandardCharsets.UTF_8
                )
        )) {
            String str;
            int begin;
            int len;
            String word;
            while ((str = fileIn.readLine()) != null) {
                len = str.length();
                for (int index = 0; index < len; index++) {
                    if (!isSupportedSymbol(str, index)) {
                        continue;
                    }
                    begin = index;
                    index = getIndexWordEnd(str, index);
                    if (index - begin >= 3) {
                        begin = index - 3;
                    }
                    word = str.substring(begin, index).toLowerCase();
                    dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
                    index = getIndexWordEnd(str, index);
                }
            }

        } catch (IOException e) {
            System.out.println("Problem with Input File: " + e.getMessage());
        }
        try (BufferedWriter fileOut = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(args[1]),
                        StandardCharsets.UTF_8
                )
        )) {
            for (Map.Entry<String, Integer> word : dictionary.entrySet()) {
                fileOut.write(word.getKey() + " " + word.getValue());
                fileOut.newLine();
            }

        } catch (IOException e) {
            System.out.println("Problem with Output File: " + e.getMessage());
        }
    }
}
