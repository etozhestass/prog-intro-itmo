package hw13.exceptions;

public class CheckedVariable extends AbstractValue {
    private final String value;

    public CheckedVariable(String value) {
        super(value);
        this.value = value;
    }

    @Override
    public double evaluate(double x) {
        if ("x".equals(value)) {
            return x;
        }
        return 0;
    }

    @Override
    public int evaluate(int x) {
        if ("x".equals(value)) {
            return x;
        }
        return 0;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return switch(value) {
            case "x" -> x;
            case "y" -> y;
            case "z" -> z;
            default -> 0;
        };
    }

    @Override
    public boolean equals(Object obj) {
        return equalsImpl(obj) && value.equals(((CheckedVariable) obj).value);
    }
}
