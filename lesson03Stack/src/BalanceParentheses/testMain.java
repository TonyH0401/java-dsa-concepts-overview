package BalanceParentheses;

public class testMain {
    public static void main(String[] args) throws Exception {
        try {
            String expr = "([)";
            System.out.println(areBracketBalanced(expr));
            // String expr2 = "([{}]))";
            // System.out.println(areBracketBalanced(expr2));
            // String expr3 = "1+2(1+2)";
            // System.out.println(areBracketBalanced(expr3));
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
