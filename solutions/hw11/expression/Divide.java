package hw11.expression;

public class Divide extends AbstractBinary {
    public Divide(MyExpression leftPart, MyExpression rightPart) {
        super(leftPart, rightPart, "/", true, true);
    }


    @Override
    protected int getType() {
        return 2;
    }

    @Override
    protected int calculate(int x, int y) {
        return x / y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x / y;
    }
}

