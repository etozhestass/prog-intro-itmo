package hw13.exceptions;

import expression.TripleExpression;
import expression.parser.TripleParser;

import java.util.Scanner;

public class MyTest {
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);
        TripleParser parser = new ExpressionParser();
        TripleExpression expression = parser.parse("1 * count");
        System.out.println(expression.toString());
        System.out.println(expression.toMiniString());
        System.out.println(expression.evaluate(1, 1, 1));
    }
}
