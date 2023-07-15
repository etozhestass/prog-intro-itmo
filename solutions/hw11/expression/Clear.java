package hw11.expression;

public class Clear extends AbstractBinary {
    public Clear(MyExpression leftPart, MyExpression rightPart) {
        super(leftPart, rightPart, "clear", true, false);
    }

    @Override
    protected int getType() {
        return 0;
    }

    @Override
    protected int calculate(int x, int y) {
        return x & ~(1 << y);
    }

    @Override
    protected double calculate(double x, double y) {
        return 0;
    }
}
