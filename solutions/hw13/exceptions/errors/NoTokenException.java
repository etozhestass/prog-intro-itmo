package hw13.exceptions.errors;

public class NoTokenException extends ParserException{
    public NoTokenException(String message) {
        this.message = "Expected token: " + message;
    }
}
