package hw13.exceptions;

import hw11.expression.MyExpression;
import hw13.exceptions.errors.NegateNumberLog;

public class CheckedLog extends AbstractUnary {

    private final MyExpression value;

    public CheckedLog(MyExpression value) {
        super(value, "log10");
        this.value = value;
    }

    // :NOTE: копипаста в evaluate при вычислении логарифма
    @Override
    public int evaluate(int x, int y, int z) {
        int num = value.evaluate(x, y, z);
        isPositive(num);
        int count = 0;
        while (num >= 10) {
            num /= 10;
            count++;
        }
        return count;
    }

    private void isPositive(int x) {
        if (x <= 0) {
            throw new NegateNumberLog("The number less than zero: " + x);
        }
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
