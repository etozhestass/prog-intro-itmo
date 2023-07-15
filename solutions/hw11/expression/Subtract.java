package hw11.expression;

public class Subtract extends AbstractBinary {
    public Subtract(MyExpression leftPart, MyExpression rightPart) {
        super(leftPart, rightPart, "-", true, false);
    }


    @Override
    protected int getType() {
        return 1;
    }

    @Override
    protected int calculate(int x, int y) {
        return x - y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x - y;
    }
}

