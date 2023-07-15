package hw12.parser;

import expression.TripleExpression;
import expression.parser.TripleParser;

import java.util.Scanner;

public class MyTest {
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);
        TripleParser parser = new ExpressionParser();
        TripleExpression expression = parser.parse(in.nextLine());
        System.out.println("toString: \n" + expression.toString());
        System.out.println(expression.toMiniString());
        System.out.println(expression.getClass());
        System.out.println(expression.evaluate(1, 1, 1));
    }
}
