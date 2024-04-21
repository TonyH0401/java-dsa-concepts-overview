package InfixToPostfix;

import StackSLLGenerics.*;
import BalanceParentheses.*;

public class testMainIFPF {
    public static void main(String[] args) throws Exception {
        String infixExpression = "1+(2*3-4/2)*5";
        if (!testMainBP.areBracketBalanced(infixExpression)) {
            System.out.println("'" + infixExpression + "' is not balanced");
        } else {
            System.out.println("'" + infixExpression + "' is balanced: " + infixToPostfix(infixExpression));
        }
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        StackSLL<Character> stack = new StackSLL<Character>();
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
