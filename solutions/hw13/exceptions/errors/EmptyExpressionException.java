package hw13.exceptions.errors;

public class EmptyExpressionException extends ExpressionException {
    public EmptyExpressionException() {
        this.message = "Empty expression";
    }
    public EmptyExpressionException(String string, int pos) {
        if (pos < string.length() - 1) {
            pos++;
        }
        this.message = "Empty expression: " + string.substring(0, pos) + "*here*" + string.substring(pos);
    }
}
