package hw13.exceptions.errors;

public class UnexpectedTokenException extends ParserException{
    public UnexpectedTokenException(String token, String expression, int pos) {
        pos = pos > 0 ? pos - 1 : pos;
        this.message = "Unexpected token: " + token + " at expression: \"" + expression.substring(0, pos) + "///here--->" + expression.substring(pos) +  '"';
    }

    public UnexpectedTokenException(String token) {
        this.message = "Unexpected token: '" + token + "'";
    }
}
