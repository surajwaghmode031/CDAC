package Expression;

import java.util.Stack;

public class Prefix {

    public static int calculator(int a, int b, char operator) {
        switch (operator) {
            case '$':
                return (int) Math.pow(a, b);
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '/':
                return a / b;
            case '-':
                return a - b;
            case '%':
                return a % b;
        }
        return 0;
    }

    public static int solvePrefix(String prefix) {

        // stack for operands
        Stack<Integer> stack = new Stack<>();

        // traverse prefix from RIGHT to LEFT
        for (int i = prefix.length() - 1; i >= 0; i--) {

            char sym = prefix.charAt(i);

            // if digit, push into stack
            if (Character.isDigit(sym)) {
                String operand = Character.toString(sym);
                stack.push(Integer.parseInt(operand));
            } 
            else {
                // pop two operands
                int a = stack.pop();
                int b = stack.pop();

                // calculate
                int c = calculator(a, b, sym);

                // push result back
                stack.push(c);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "+-+59*4-8/62$1-73";
        int result = solvePrefix(prefix);
        System.out.println(result);
    }
}
