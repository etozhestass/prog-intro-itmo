package hw13.exceptions.errors;

public class OverflowException extends ExpressionException {

    public OverflowException(String type) {
        this.message = "Overflow(" + type + ")";
    }
}
