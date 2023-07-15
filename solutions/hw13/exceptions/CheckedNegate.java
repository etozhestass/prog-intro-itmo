package hw13.exceptions;

import hw11.expression.MyExpression;
import hw13.exceptions.errors.OverflowException;

public class CheckedNegate extends AbstractUnary {
    private final MyExpression value;

    public CheckedNegate(MyExpression value) {
        super(value, "-");
        this.value = value;
    }

    @Override
    public double evaluate(double x) {
        return -1.0 * value.evaluate(x);
    }

    @Override
    public int evaluate(int x) {
        checkOverflow(value.evaluate(x));
        return -1 * value.evaluate(x);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        checkOverflow(value.evaluate(x, y, z));
        return -1 * value.evaluate(x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        return equalsImpl(obj) && ((CheckedNegate) obj).value.equals(this.value);
    }
    protected void checkOverflow(int res) {
        if (res == Integer.MIN_VALUE) {
            throw new OverflowException("UnaryMin");
        }
    }
}
