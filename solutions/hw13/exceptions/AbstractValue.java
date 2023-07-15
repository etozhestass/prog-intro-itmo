package hw13.exceptions;

import expression.DoubleExpression;
import expression.ToMiniString;
import expression.TripleExpression;
import hw11.expression.MyExpression;

import java.util.Objects;

public abstract class AbstractValue implements DoubleExpression, ToMiniString, TripleExpression, MyExpression {
    private final String value;

    protected AbstractValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value) * 179;
    }
    public boolean equalsImpl(Object obj) {
        return obj != null && obj.getClass() == getClass();
    }
    @Override
    public String toString() {
        return value;
    }
}
