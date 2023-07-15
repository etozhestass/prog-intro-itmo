package hw2;

public class Sum {
    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            for (int indexStart = 0, indexEnd = 0; indexEnd < arg.length(); indexStart = ++indexEnd) {
                while (indexEnd < arg.length() && !Character.isWhitespace(arg.charAt(indexEnd))) {
                    indexEnd++;
                }
                if (indexEnd != indexStart) {
                    sum += Integer.parseInt(arg.substring(indexStart, indexEnd));
                }
            }
        }
        System.out.println(sum);
    }
}
