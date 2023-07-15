package hw11.expression;

public class Negate extends AbstractUnary {
    private final MyExpression value;

    public Negate(MyExpression value) {
        super(value, "-");
        this.value = value;
    }

    @Override
    public double evaluate(double x) {
        return -1.0 * value.evaluate(x);
    }

    @Override
    public int evaluate(int x) {
        return -1 * value.evaluate(x);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return -1 * value.evaluate(x, y, z);
    }
    @Override
    public boolean equals(Object obj) {
        return equalsImpl(obj) && ((Negate) obj).value.equals(this.value);
    }
}
