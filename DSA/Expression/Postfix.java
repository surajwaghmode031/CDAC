package Expression;

import java.util.Stack;

public class Postfix {
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

    public static int solvePostfix(String postfix) {

        // stack for operands
        Stack<Integer> stack = new Stack<>();
        // travels postfix from left to right
        for (int i = 0; i < postfix.length(); i++) {
            // accessing a character 1 by 1
            char sym = postfix.charAt(i);
            // check it is digit or not
            if (Character.isDigit(sym)) {
                // stack.push(sym); --> int give char symbol but Stack is integer
                // we cannot convet char(assci value) to integer hence we wnt to convert into
                // string
                // stack.push(sym);
                String operand = Character.toString(sym); // convert char into string
                stack.push(Integer.parseInt(operand));
            } else {
                // pop two opprand from stack
                int b = stack.pop();
                int a = stack.pop();
                // calculate result
                int c = calculator(a, b, sym);
                // push result back to stack
                stack.push(c);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "59+4862/-*-173-$+";
        int result = solvePostfix(postfix);
        System.out.println(result);
    }
}
