package hw13.exceptions;

import hw11.expression.MyExpression;
import hw13.exceptions.errors.DivideByZeroException;
import hw13.exceptions.errors.OverflowException;

public class CheckedDivide extends AbstractBinary {
    public CheckedDivide(MyExpression leftPart, MyExpression rightPart) {
        super(leftPart, rightPart, "/", true, true);
    }


    @Override
    protected int getType() {
        return 2;
    }

    @Override
    protected int calculate(int x, int y) {
        checkOverflow(x, y);
        checkDivideByZero(y);
        return x / y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x / y;
    }
    protected void checkDivideByZero(int y) {
        if (y == 0) {
            throw new DivideByZeroException();
        }
    }
    protected void checkOverflow(int x, int y) {
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new OverflowException("Divide");
        }
    }
}

