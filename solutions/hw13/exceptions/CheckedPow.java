package hw13.exceptions;

import hw11.expression.MyExpression;
import hw13.exceptions.errors.NegateNumberLog;
import hw13.exceptions.errors.OverflowException;


public class CheckedPow extends AbstractUnary {
    private final MyExpression value;

    public CheckedPow(MyExpression value) {
        super(value, "pow10");
        this.value = value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int num = value.evaluate(x, y, z);
        int res = 1;
        isPositive(num);
        checkOverflow(num);
        for (int i = 0; i < num; i++) {
            res *= 10;
        }
        return res;
    }

    private void isPositive(int x) {
        if (x < 0) {
            throw new NegateNumberLog("The number less than zero: " + x);
        }
    }
    private void checkOverflow(int x) {
        if (x > 9) {
            throw new OverflowException("");
        }
    }

    @Override
    public double evaluate(double x) {
        return value.evaluate(0, (int) x, 0);
    }

    @Override
    public int evaluate(int x) {
        return 0;
    }
}
