package hw13.exceptions.errors;

public class ExpressionException extends RuntimeException{
    String message;

    @Override
    public String getMessage() {
        return message;
    }
}
