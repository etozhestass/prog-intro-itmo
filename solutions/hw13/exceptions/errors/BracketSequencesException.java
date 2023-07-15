package hw13.exceptions.errors;

public class BracketSequencesException extends ParserException {
    public BracketSequencesException(String message) {
        this.message = "Not correct Bracket Sequence. No " + message;
    }
    public BracketSequencesException(String message, String expression, int pos) {
        this.message = "Not correct Bracket Sequence. No " + message + expression.substring(0, pos) + "///here--->" + expression.substring(pos) ;
    }
}
