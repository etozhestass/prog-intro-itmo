package hw13.exceptions;

import hw11.expression.MyExpression;

public abstract class AbstractUnary implements MyExpression {
    private final MyExpression value;
    private final String operator;

    public AbstractUnary(MyExpression value, String operator) {
        this.value = value;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", operator, value.toString());
    }

    @Override
    public String toMiniString() {
        if (value instanceof AbstractBinary) {
            return operator + "(" + value.toMiniString() + ")";
        }
        return operator + ' ' + value.toMiniString();
    }
    public boolean equalsImpl(Object obj) {
        return obj != null && obj.getClass() == getClass();
    }
}
