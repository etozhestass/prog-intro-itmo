package hw11.expression;

public class Log extends AbstractUnary {

    private final MyExpression value;

    public Log(MyExpression value) {
        super(value, "log10");
        this.value = value;
    }

    // :NOTE: копипаста в evaluate при вычислении логарифма
    @Override
    public int evaluate(int x, int y, int z) {
        int num = value.evaluate(x, y, z);
        int count = 0;
        while (num >= 10) {
            num /= 10;
            count++;
        }
        return count;
    }

    @Override
    public int evaluate(int x) {
        return evaluate(0, x, 0);
    }

    @Override
    public double evaluate(double x) {
        return value.evaluate(x);
    }
}
