package hw5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ScannerExample {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner("       100  word -abcd\njust next line with @random symbols!111");
        //Scanner scanner = new Scanner(new File("solutions/hw5/example.txt"), StandardCharsets.UTF_8);
        if (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }

        if (scanner.hasNextWord()) {
            System.out.println(scanner.nextWord());
        }

        if (scanner.hasNextAbc()) {
            System.out.println(scanner.nextAbc());
        }

        if (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
        try (Scanner scannerAutoClosable = new Scanner(System.in)) {
            System.out.println(scannerAutoClosable.nextInt());
        } catch (NumberFormatException e) {
            System.out.println("error");
        }
    }
}
