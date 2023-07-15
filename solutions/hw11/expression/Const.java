package hw11.expression;

public class Const extends AbstractValue {
    private final String value;

    public Const(int value) {
        super(String.valueOf(value));
        this.value = Integer.toString(value);
    }
    public Const(double value) {
        super(String.valueOf(value));
        this.value = Double.toString(value);
    }

    @Override
    public double evaluate(double x) {
        return Double.parseDouble(value);
    }

    @Override
    public int evaluate(int x) {
        return Integer.parseInt(value);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return this.evaluate(0);
    }


    @Override
    public boolean equals(Object obj) {
        return equalsImpl(obj) && ((Const) obj).value.equals(this.value);
    }
}
