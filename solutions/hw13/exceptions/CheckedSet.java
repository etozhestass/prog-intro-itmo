package hw13.exceptions;

import hw11.expression.MyExpression;

public class CheckedSet extends AbstractBinary {
    public CheckedSet(MyExpression leftPart, MyExpression rightPart) {
        super(leftPart, rightPart, "set", true, false);
    }

    @Override
    protected int getType() {
        return 0;
    }

    @Override
    protected int calculate(int x, int y) {
        return x | (1<<y);
    }

    @Override
    protected double calculate(double x, double y) {
        return 0;
    }
}
