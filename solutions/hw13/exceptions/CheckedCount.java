package hw13.exceptions;

import hw11.expression.MyExpression;

public class CheckedCount extends AbstractUnary {

    private final MyExpression value;

    public CheckedCount(MyExpression value) {
        super(value, "count");
        this.value = value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return Integer.bitCount(value.evaluate(x, y, z));
    }

    @Override
    public double evaluate(double x) {
        return Integer.bitCount(value.evaluate((int) x));
    }

    @Override
    public int evaluate(int x) {
        return Integer.bitCount(value.evaluate(x));
    }
}
