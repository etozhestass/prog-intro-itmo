package hw6;

import hw5.Scanner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class WsppCountPosition {
    public record Pair(String key, Integer value) implements Comparable<Pair> {
        public int compareTo(Pair pair) {
            return value.compareTo(pair.value());
        }
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Map<String, IntList> dictionary = new LinkedHashMap<>();
        ArrayList<Pair> indexList = new ArrayList<>();
        try (Scanner in = new Scanner(new File(args[0]), StandardCharsets.UTF_8)) {
            int indexLine = 1;
            int indexWord;
            while (in.hasNextLine()) {
                Scanner string = new Scanner(in.nextLine());
                indexWord = 1;
                while (string.hasNextWord()) {
                    String word = string.nextWord().toLowerCase();
                    IntList ids = dictionary.getOrDefault(word, new IntList());
                    ids.add(indexLine);
                    ids.add(indexWord);
                    dictionary.putIfAbsent(word, ids);
                    indexWord++;
                }
                indexLine++;
                string.close();
            }
        } catch (IOException e) {
            System.out.println("Problem with Input Data");
            e.printStackTrace();
        } finally {
            for (String str : dictionary.keySet()) {
                indexList.add(new Pair(str, dictionary.get(str).size() / 2));
            }
            Collections.sort(indexList);
        }
        try (BufferedWriter fileOut = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(args[1]),
                        StandardCharsets.UTF_8
                )
        )) {
            for (Pair currentPair : indexList) {
                fileOut.write(currentPair.key() + " " + currentPair.value() + " " + dictionary.get(currentPair.key()).toPairs());
                fileOut.newLine();
            }
        } catch (IOException e) {
            System.out.println("Problem with Output File");
            e.printStackTrace();
        }
    }
}