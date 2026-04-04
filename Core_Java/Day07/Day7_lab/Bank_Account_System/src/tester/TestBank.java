package tester;

import java.util.Scanner;
import com.core.*;

public class TestBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int MAX_ACCOUNTS = 100;
        BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];
        int accountCount = 0;
        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Open Saving Account");
            System.out.println("2. Open Current Account");
            System.out.println("3. Display Account Summary");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Open Saving Account
                    if (accountCount >= MAX_ACCOUNTS) {
                        System.out.println("Bank full. Cannot open more accounts.");
                        break;
                    }
                    System.out.print("Enter Account Number: ");
                    int saNumber = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double saBalance = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String saName = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String saPhone = sc.nextLine();
                    System.out.print("Enter Interest Rate: ");
                    double interestRate = sc.nextDouble();

                    accounts[accountCount++] = new SavingAccount(saNumber, saBalance, saName, saPhone, interestRate);
                    System.out.println("Saving account opened successfully!");
                    break;

                case 2: // Open Current Account
                    if (accountCount >= MAX_ACCOUNTS) {
                        System.out.println("Bank full. Cannot open more accounts.");
                        break;
                    }
                    System.out.print("Enter Account Number: ");
                    int caNumber = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double caBalance = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String caName = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String caPhone = sc.nextLine();
                    System.out.print("Enter Overdraft Limit: ");
                    double overdraft = sc.nextDouble();

                    accounts[accountCount++] = new CurrentAccount(caNumber, caBalance, caName, caPhone, overdraft);
                    System.out.println("Current account opened successfully!");
                    break;

                case 3: { // Display Account Summary
                    System.out.print("Enter Account Number: ");
                    int searchNumber = sc.nextInt();

                    boolean flag = false;
                    for (BankAccount a : accounts) {
                        if (a != null && a.getAccountNumber() == searchNumber) {
                            flag = true;
                
                            if (a instanceof SavingAccount) {
                                System.out.println("Account Type: Saving Account     "+a.getAccountSummary());
                             
                            } else if (a instanceof CurrentAccount) {
                                System.out.println("Account Type: Current Account    "+a.getAccountSummary());
                            }
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("Account not found!");
                    }
                    break;
                }

                case 4: { // Deposit
                    System.out.print("Enter Account Number: ");
                    int depNumber = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmount = sc.nextDouble();

                    boolean flag = false;
                    for (BankAccount a : accounts) {
                        if (a != null && a.getAccountNumber() == depNumber) {
                            flag = true;
                            a.deposite(depAmount); // polymorphic call
                            System.out.println(a.getAccountSummary());
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("Account not found!");
                    }
                    break;
                }

                case 5: { // Withdraw
                    System.out.print("Enter Account Number: ");
                    int withNumber = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withAmount = sc.nextDouble();

                    boolean flag = false;
                    for (BankAccount a : accounts) {
                        if (a != null && a.getAccountNumber() == withNumber) {
                            flag = true;
                            // Exception handling
                            try {
                            a.withdrawAmount(withAmount); // polymorphic call
                            System.out.println(a.getAccountSummary());
                            }catch(Exception e) {
                            	System.out.println(e.getMessage());
                            }
                        }
                    }
                    if (!flag) {
                        System.out.println("Account not found!");
                    }
                    break;
                }
                case 6 : {
         
                     System.out.println("Exiting... Thank you!");
                }
            }
        } while (choice != 6);

       
    }
}


