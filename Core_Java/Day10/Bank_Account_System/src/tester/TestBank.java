package tester;

import java.util.Scanner;
import com.Bank.Service.BankServiceImpl;
import com.Bank.core.AccountType;
import com.Bank.exception.BankException;
import com.Bank.exception.insufficientBalanceException;

public class TestBank {

    public static void main(String[] args) throws insufficientBalanceException {

        Scanner sc = new Scanner(System.in);
        final int MAX_ACCOUNTS = 100;
        BankServiceImpl bankService = new BankServiceImpl(MAX_ACCOUNTS);

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
            sc.nextLine();

            switch (choice) {

                case 1:{ // Open Saving Account
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
                    sc.nextLine();
                    System.out.print("Enter Account Type (saving/current): ");
                    String saType = sc.nextLine();

                    try {
                    	 AccountType type = AccountType.valueOf(saType.toUpperCase());
                        bankService.openSavingAccount(saNumber, saBalance, saName, saPhone, interestRate, type);
                        System.out.println("Saving account opened successfully!");
                    } catch (BankException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 2:{ // Open Current Account
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
                    sc.nextLine();
                    System.out.print("Enter Account Type (saving/current): ");
                    String caType = sc.nextLine();

                    try {
                        // Enum conversion only if type matches "current"
                        AccountType type = AccountType.valueOf(caType.toUpperCase());
                        bankService.openCurrentAccount(caNumber, caBalance, caName, caPhone, overdraft, type);
                        System.out.println("Current account opened successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid account type! Must be saving or current.");
                    }
                    break;
                }

                case 3:
                    System.out.println(bankService.accountSummary());
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 6);

    }
}


