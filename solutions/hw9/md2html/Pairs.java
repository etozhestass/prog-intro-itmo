package hw9.md2html;

public class Pairs {
    private final String str;
    private int count;

    Pairs(String str) {
        this.str = str;
        this.count = 0;
    }
    String getStr() {
        return str;
    }
    int getCount() {
        return count;
    }

    void plusCount() {
        count += 1;
    }
    void minusCount() {
        count -= 1;
    }
    void zeroCount() {
        count = 0;
    }
}
