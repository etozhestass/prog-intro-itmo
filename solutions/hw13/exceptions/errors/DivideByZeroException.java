package hw13.exceptions.errors;

public class DivideByZeroException extends ExpressionException {
    public DivideByZeroException() {
        this.message = "Division by zero";
    }
}
