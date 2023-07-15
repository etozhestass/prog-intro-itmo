package hw12.parser;

import expression.TripleExpression;
import expression.parser.TripleParser;
import hw11.expression.*;

import java.util.List;

public class ExpressionParser extends BaseParser implements TripleParser {
    private final List<String> stringsBinary = List.of("set", "clear", "+", "-", "*", "/");
    private final List<String> stringsUnary = List.of("count");
    @Override
    public TripleExpression parse(final String expression) {
        setSource(new StringSource(expression));
        return parse(1);
    }
    private MyExpression parse(int priority) {
        if (getBinaryOperation(priority).isEmpty()) {
            return element();
        }
        MyExpression result = parse(priority + 1);
        skipWhitespace();
        while (hasNext() && getBinaryOperation(priority).contains(top())) {
            skipWhitespace();
            result = getBinaryExpression(getToken(stringsBinary, stringsUnary), result, parse(priority + 1));
            skipWhitespace();
        }
        return result;
    }
    private MyExpression element() {
        skipWhitespace();
        char ch = top();
        if (ch == '(') {
            next();
            MyExpression result = parse(1);
            if (equals(')')) {
                skipWhitespace();
                next();
            }
            return result;
        } else if (ch == '-') {
            next();
            if (!isWhitespace() && between(top(), '1', '9')) {
                return new Const(parseInt(true));
            } else {
                return new Negate(element());
            }
        } else if (between(ch, '0', '9')) {
            return new Const(parseInt(false));
        } else if (between(ch, 'x', 'z')) {
            return new Variable(String.valueOf(next()));
        }
        return getUnaryExpression(next() + getWord(), element());
    }
    private MyExpression getBinaryExpression(String operator, MyExpression result, MyExpression parse) {
        return switch (operator) {
            case "+" -> new Add(result, parse);
            case "-" -> new Subtract(result, parse);
            case "*" -> new Multiply(result, parse);
            case "/" -> new Divide(result, parse);
            case "set" -> new Set(result, parse);
            case "clear" -> new Clear(result, parse);
            default -> throw error("Impossible");
        };
    }
    private MyExpression getUnaryExpression(String operation, MyExpression element) {
        return switch (operation) {
            case "count" -> new Count(element);
            default -> throw error("Impossible");
        };
    }
    private List<Character> getBinaryOperation(int priority) {
        return switch (priority) {
            case 1 -> List.of('s', 'c');
            case 2 -> List.of('+', '-');
            case 3 -> List.of('*', '/');
            default -> List.of();
        };
    }
}
