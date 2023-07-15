package hw13.exceptions;

import hw11.expression.MyExpression;
import expression.TripleExpression;
import hw13.exceptions.errors.BracketSequencesException;
import hw13.exceptions.errors.EmptyExpressionException;
import hw13.exceptions.errors.NoTokenException;
import hw13.exceptions.errors.UnexpectedTokenException;
import hw12.parser.BaseParser;
import hw12.parser.StringSource;
import expression.parser.TripleParser;

import java.util.List;

public class ExpressionParser extends BaseParser implements TripleParser {
    private final List<String> stringsBinary = List.of("set", "clear", "+", "-", "*", "/");
    private final List<String> stringsUnary = List.of("count", "log10", "pow10");
    private final List<Character> stringOperationPrefix = List.of('s', 'c', 'l', 'p', '+', '-', '*', '/');
    private int countBracket;

    @Override
    public TripleExpression parse(final String expression) {
        countBracket = 0;
        setSource(new StringSource(expression));
        skipWhitespace();
        if (expression.isEmpty() || !hasNext()) {
            throw new EmptyExpressionException();
        }
        TripleExpression result = parse(1);
        skipWhitespace();
        if (hasNext() && top() == ')') {
            countBracket--;
            next();
            skipWhitespace();
        }
        if (hasNext()) {
            throw new UnexpectedTokenException(getToken(stringsBinary, stringsBinary), getData(), getPos() - 1);
        }
        if (countBracket > 0) {
            throw new BracketSequencesException("opening brackets: " + expression);
        } else if (countBracket < 0) {
            throw new BracketSequencesException("closing brackets: " + expression);
        }
        return result;
    }

    private MyExpression parse(int priority) {
        if (getBinaryOperation(priority).isEmpty()) {
            return element();
        }
        skipWhitespace();
        MyExpression result = parse(priority + 1);
        if (hasNext() && top() == '(') {
            throw new BracketSequencesException("closing Brackets: ", getData(), getPos());
        }
        if (hasNext() && !isSupportedSymbol(top())) {
            throw new UnexpectedTokenException(String.valueOf(top()), getData(), getPos() + 1);
        }
        while (hasNext() && getBinaryOperation(priority).contains(top())) {
            skipWhitespace();
            String operation = getToken(stringsBinary, stringsUnary);
            if (!stringsBinary.contains(operation) || operation.length() > 1 && !hasNext() && !isWhitespace()) {
                throw new UnexpectedTokenException(
                        operation + getToken(stringsBinary, stringsUnary),
                        getData(),
                        getPos()
                );
            }
            result = getBinaryExpression(operation, result, parse(priority + 1));
        }
        return result;
    }

    private MyExpression element() {
        skipWhitespace();
        if (!hasNext()) {
            throw new NoTokenException(getData());
        }
        if (!isSupportedSymbol(top())) {
            throw new UnexpectedTokenException(String.valueOf(top()), getData(), getPos());
        }
        if (equals('(')) {
            countBracket++;
            next();
            if (equals(')')) {
                throw new EmptyExpressionException(getData(), getPos() - 1);
            }
            MyExpression result = parse(1);
            skipWhitespace();
            if (!hasNext()) {
                throw new BracketSequencesException("closing brackets: ", getData(), getPos());
            }
            if (!isSupportedSymbol(top())) {
                throw new UnexpectedTokenException(String.valueOf(top()), getData(), getPos());
            }
            if (equals(')')) {
                countBracket--;
                skipWhitespace();
                next();
            }
            return result;
        } else if (equals('-')) {
            next();
            if (!hasNext()) {
                throw new UnexpectedTokenException("-", getData(), getPos());
            }
            if (!isWhitespace() && between(top(), '1', '9')) {
                return new CheckedConst(parseInt(true));
            } else {
                return new CheckedNegate(element());
            }
        } else if (between(top(), '0', '9')) {
            return new CheckedConst(parseInt(false));
        } else if (between(top(), 'x', 'z')) {
            return new CheckedVariable(String.valueOf(next()));
        } else {
            String operation = String.valueOf(next());
            if (!stringOperationPrefix.contains(operation.charAt(0))) {
                throw new UnexpectedTokenException(operation, getData(), getPos());
            }
            if (!stringsBinary.contains(operation) && !stringsUnary.contains(operation)) {
                operation += getToken(stringsBinary, stringsUnary);
            }
            if (stringsUnary.contains(operation)) {
                if (hasNext() && !isWhitespace() && !equals('(')) {
                    throw new UnexpectedTokenException(operation + top(), getData(), getPos() + 1);
                }
                return getUnaryExpression(operation, element());
            }
            throw new UnexpectedTokenException(operation, getData(), getPos() - operation.length());
        }
    }

    private MyExpression getBinaryExpression(String operator, MyExpression result, MyExpression parse) {
        return switch (operator) {
            case "+" -> new CheckedAdd(result, parse);
            case "-" -> new CheckedSubtract(result, parse);
            case "*" -> new CheckedMultiply(result, parse);
            case "/" -> new CheckedDivide(result, parse);
            case "set" -> new CheckedSet(result, parse);
            case "clear" -> new CheckedClear(result, parse);
            default -> throw error("Impossible");
        };
    }

    private MyExpression getUnaryExpression(String operation, MyExpression element) {
        return switch (operation) {
            case "count" -> new CheckedCount(element);
            case "log10" -> new CheckedLog(element);
            case "pow10" -> new CheckedPow(element);
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

    private boolean isSupportedSymbol(char ch) {
        return between(ch, '0', '9') || between(ch, 'x', 'z') ||
                ch == '(' || ch == ')' || stringOperationPrefix.contains(ch);
    }
}
