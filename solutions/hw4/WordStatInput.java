package hw4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordStatInput {
    private static boolean isSupportedSymbol(String str, int i) {
        char chr = str.charAt(i);
        return Character.isLetter(chr) ||
                Character.getType(chr) == Character.DASH_PUNCTUATION ||
                chr == '\'';
    }

    public static void main(String[] args) {
        Map<String, Integer> dictionary = new LinkedHashMap<>();
        try (BufferedReader fileIn = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(args[0]),
                        StandardCharsets.UTF_8
                )
        )) {
            String str;
            int begin;
            int len;
            while ((str = fileIn.readLine()) != null) {
                len = str.length();
                for (int index = 0; index < len; index++) {
                    if (!isSupportedSymbol(str, index)) {
                        continue;
                    }
                    begin = index;
                    while (index < len && isSupportedSymbol(str, index)) {
                        index++;
                    }
                    String word = str.substring(begin, index).toLowerCase();
                    dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
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