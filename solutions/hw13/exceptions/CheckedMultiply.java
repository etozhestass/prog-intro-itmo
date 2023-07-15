package hw13.exceptions;

import hw11.expression.MyExpression;
import hw13.exceptions.errors.OverflowException;

public class CheckedMultiply extends AbstractBinary {
    public CheckedMultiply(MyExpression leftPart, MyExpression rightPart) {
        super(leftPart, rightPart, "*", false, true);
    }


    @Override
    protected int getType() {
        return 2;
    }

    @Override
    protected int calculate(int x, int y) {
        checkOverflow(x, y);
        return x * y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x * y;
    }
    protected void checkOverflow(int x, int y) {
        int res = x * y;
        if (x != 0 && y != 0 && (res / x != y || res / y != x)) {
            throw new OverflowException("Multiply");
        }
    }
}

