package hw11.expression;

public class Pow extends AbstractUnary {
    private final MyExpression value;

    public Pow(MyExpression value) {
        super(value, "pow10");
        this.value = value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int num = value.evaluate(x, y, z);
        int res = 1;
        for (int i = 0; i < num; i++) {
            res *= 10;
        }
        return res;
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
