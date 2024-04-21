package BalanceParentheses;

import StackSLLGenerics.*;

public class testMainBP {
    public static void main(String[] args) throws Exception {
        try {
            String expr = "([)";
            System.out.println("Is this expression '" + expr + "' balanced: " + areBracketBalanced(expr));
            String expr2 = "([{}]))";
            System.out.println("Is this expression '" + expr2 + "' balanced: " + areBracketBalanced(expr2));
            String expr3 = "([{}])";
            System.out.println("Is this expression '" + expr3 + "' balanced: " + areBracketBalanced(expr3));
            String expr4 = "1+2*(1+2)";
            System.out.println("Is this expression '" + expr4 + "' balanced: " + areBracketBalanced(expr4));
            String expr5 = "(1+2)+(1+2)";
            System.out.println("Is this expression '" + expr5 + "' balanced: " + areBracketBalanced(expr5));
            String expr6 = "(1+2))+(1+2)";
            System.out.println("Is this expression '" + expr6 + "' balanced: " + areBracketBalanced(expr6));
        } catch (Exception e) {
            System.err.println("> Got an error: " + e.getMessage());
        }
    }

    /*
     * I am using Stack the check for the balance parentheses but there is a better
     * way.
     */
    public static boolean areBracketBalanced(String expression) {
        StackSLL<Character> stack = new StackSLL<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return (stack.isEmpty());
    }
}
