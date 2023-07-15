package hw13.exceptions;

public class CheckedConst extends AbstractValue {
    private final String value;

    public CheckedConst(int value) {
        super(String.valueOf(value));
        this.value = Integer.toString(value);
    }
    public CheckedConst(double value) {
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
        return equalsImpl(obj) && ((CheckedConst) obj).value.equals(this.value);
    }
}
