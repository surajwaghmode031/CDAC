import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation;
        double num1, num2, result;

        while (true) {
            System.out.print("Enter operation (add|subtract|multiply|divide): ");
            operation = sc.next();

            if (!operation.equals("add") && !operation.equals("subtract") &&
                !operation.equals("multiply") && !operation.equals("divide")) {
                System.out.println("Exiting program...");
                break;
            }

            System.out.print("Enter first number: ");
            num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            num2 = sc.nextDouble();

            switch (operation) {
                case "add":
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case "subtract":
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case "multiply":
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case "divide":
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
            }
        }

        sc.close();
    }
}
