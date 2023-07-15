package hw6;

import hw5.Scanner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Wspp {
    public static void main(String[] args) {
        Map<String, IntList> dictionary = new LinkedHashMap<>();
        int index = 1;
        IntList indexList;

        try (Scanner in = new Scanner(new File(args[0]), StandardCharsets.UTF_8)) {
            while (in.hasNextLine()) {
                Scanner str = new Scanner(in.nextLine());
                while (str.hasNextWord()) {
                    String word = str.nextWord().toLowerCase();
                    indexList = dictionary.getOrDefault(word, new IntList());
                    indexList.add(index++);
                    dictionary.putIfAbsent(word, indexList);
                }
                str.close();
            }
        } catch (IOException e) {
            System.out.println("Problem with Input Data");
            e.printStackTrace();
        }
        try (BufferedWriter fileOut = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(args[1]),
                        StandardCharsets.UTF_8
                )
        )) {
            for (Map.Entry<String, IntList> en : dictionary.entrySet()) {
                fileOut.write(en.getKey() + ' ' + en.getValue().size() + ' ' + en.getValue());
                fileOut.newLine();
            }
        } catch (IOException e) {
            System.out.println("Problem with Output File");
            e.printStackTrace();

        }
    }
}
