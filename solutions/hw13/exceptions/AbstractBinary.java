package hw13.exceptions;

import hw11.expression.MyExpression;

import java.util.Objects;

public abstract class AbstractBinary implements MyExpression {
    private final MyExpression leftPart;
    private final MyExpression rightPart;
    private final String operator;
    private final boolean priority;
    private final boolean isCommutative;

    protected abstract int getType();

    protected abstract int calculate(int x, int y);

    protected abstract double calculate(double x, double y);

    public AbstractBinary(MyExpression leftPart, MyExpression rightPart, String operator, boolean priority, boolean isDistributive) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
        this.operator = operator;
        this.priority = priority;
        this.isCommutative = isDistributive;
    }

    @Override
    public double evaluate(double x) {
        return calculate(leftPart.evaluate(x), rightPart.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(leftPart.evaluate(x, y, z), rightPart.evaluate(x, y, z));
    }

    @Override
    public int evaluate(int x) {
        return calculate(leftPart.evaluate(x), rightPart.evaluate(x));
    }

    @Override
    public String toString() {
        return String.format("(%s %s %s)", leftPart.toString(), operator, rightPart.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        final AbstractBinary o = (AbstractBinary) obj;
        return leftPart.equals(o.leftPart) && rightPart.equals(o.rightPart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftPart, rightPart, operator, priority) * 179;
    }

    private boolean less(MyExpression obj) {
        if (!(obj instanceof AbstractBinary o)) {
            return false;
        }
        return o.getType() < this.getType();
    }

    @Override
    public String toMiniString() {
        return String.format("%s %s %s",
                toMiniString(leftPart, less(leftPart)),
                operator,
                toMiniString(rightPart, less(rightPart) || right(rightPart))
        );
    }

    private String toMiniString(MyExpression obj, boolean check) {
        String parsed = "%s";
        if (check) {
            parsed = String.format("(%s)", parsed);
        }
        return String.format(parsed, obj.toMiniString());
    }

    private boolean right(MyExpression obj) {
        if (!(obj instanceof AbstractBinary o)) {
            return false;
        }
        if (priority && this.getType() >= o.getType()) {
            return true;
        }
        return o.priority && isCommutative;
    }
    public boolean equalsImpl(Object obj) {
        return obj != null && obj.getClass() == getClass();
    }
}

