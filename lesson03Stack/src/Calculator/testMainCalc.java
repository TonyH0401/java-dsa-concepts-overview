package Calculator;

import StackSLLGenerics.*;
import BalanceParentheses.*;
import InfixToPostfix.*;

/* works on singular digits */

public class testMainCalc {
    public static void main(String[] args) throws Exception {
        String infixExpression = "1+(2*3-4/2)*5-(2+9)";
        if (!testMainBP.areBracketBalanced(infixExpression)) {
            System.out.println("'" + infixExpression + "' is not balanced");
        } else {
            String postfixExpression = testMainIFPF.infixToPostfix(infixExpression);
            System.out.println(evaluatePostfix(postfixExpression));
        }
    }

    private static int evaluatePostfix(String exp) {
        StackSLL<Integer> stack = new StackSLL<Integer>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c))
                stack.push(c - '0');
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
