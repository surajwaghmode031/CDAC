package com.cdac.core;

import java.util.Scanner;

public class TestStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = null; // reference to chosen stack
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Choose Fixed Stack");
            System.out.println("2. Choose Growable Stack");
            System.out.println("3. Push Customer Data");
            System.out.println("4. Pop Customer Data");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (stack == null) {
                        stack = new FixedStack();
                        System.out.println("Fixed Stack selected!");
                    } else {
                        System.out.println("Stack already chosen!");
                    }
                    break;

                case 2:
                    if (stack == null) {
                        stack = new GrowableStack();
                        System.out.println("Growable Stack selected!");
                    } else {
                        System.out.println("Stack already chosen!");
                    }
                    break;

                case 3:
                    if (stack == null) {
                        System.out.println("NO stack chosen!!!");
                    } else {
                        System.out.print("Enter customer id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter customer address: ");
                        String addr = sc.nextLine();

                        Customer c = new Customer(id, name, addr);
                        stack.push(c);
                        System.out.println("Customer pushed successfully!");
                    }
                    break;

                case 4:
                    if (stack == null) {
                        System.out.println("NO stack chosen!!!");
                    } else {
                        Customer popped = stack.pop();
                        if (popped != null) {
                            System.out.println("Popped: " + popped);
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}

