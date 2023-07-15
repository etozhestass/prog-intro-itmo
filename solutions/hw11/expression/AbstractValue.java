package hw11.expression;

import java.util.Objects;

public abstract class AbstractValue implements MyExpression {
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
