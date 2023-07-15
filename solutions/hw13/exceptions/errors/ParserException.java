package hw13.exceptions.errors;

public class ParserException extends RuntimeException {
    String message;

    @Override
    public String getMessage() {
        return message;
    }
}
