package hw13.exceptions.errors;

public class NoCorrectWhitespace extends ParserException{
    public NoCorrectWhitespace(String message) {
        this.message = message;
    }
}
