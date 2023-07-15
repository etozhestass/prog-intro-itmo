package hw13.exceptions;

import hw11.expression.MyExpression;
import hw13.exceptions.errors.OverflowException;


public class CheckedAdd extends AbstractBinary {
    public CheckedAdd(MyExpression leftPart, MyExpression rightPart) {
        super(leftPart, rightPart, "+", false, false);
    }

    @Override
    protected int getType() {
        return 1;
    }

    @Override
    protected int calculate(int x, int y) {
        checkOverflow(x, y);
        return x + y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x + y;
    }
    private void checkOverflow(int x, int y) {
        if ((y > 0 && Integer.MAX_VALUE - y < x) || (y < 0 && Integer.MIN_VALUE - y > x)) {
            throw new OverflowException("Addition");
        }
    }
}

