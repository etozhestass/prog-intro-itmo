## [Own Fast Scanner](https://github.com/etozhestass/prog-intro-itmo/blob/main/solutions/hw5/Scanner.java)


This is a fast analogue of Scanner in java based on buffering.

It can get as source InputStream, String, File & Charset:

```java
    // from InputStream
    Scanner scannerInputStream = new Scanner(System.in);
    // from String
    Scanner scannerString = new Scanner("100");
    //from File
    Scanner scannerFile = new Scanner(new File("example.txt"), StandardCharsets.UTF_8);
```
Interface is the same as built-in Scanner:

```java
    Scanner scanner = new Scanner(System.in);

    if (scanner.hasNextInt()) { // input: 100
        System.out.println(scanner.nextInt()); // output: 100
    }

    if (scanner.hasNextWord()) { // input: word
        System.out.println(scanner.nextWord()); // output: word
    }

    if (scanner.hasNextAbc()) { // input: -abc
        System.out.println(scanner.nextAbc()); // ouput: -abc
    }

    if (scanner.hasNextLine()) { // input: just random line with @random !symbols!
        System.out.println(scanner.nextLine()); // output: just random line with @random !symbols!
    }

    scanner.close(); // close scanner
```
Also this Scanner implements AutoClosable with try-resources
```java
    try (Scanner scannerAutoClosable = new Scanner(System.in)) {
        System.out.println(scannerAutoClosable.nextInt());
    } catch (NumberFormatException e) {
        System.out.println("error");
    }
```
