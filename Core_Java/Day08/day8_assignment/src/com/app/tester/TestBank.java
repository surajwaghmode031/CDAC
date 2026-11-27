package com.app.tester;

import java.util.Scanner;

import com.app.bank.BankAccount;
import com.app.bank.CurrentAccount;
import com.app.bank.SavingAccount;
import static com.app.utils.ValidationRules.*;

public class TestBank {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BankAccount[] accounts = new BankAccount[100];
		int count = 0;
		boolean exit = false;
		while (!exit) {
			System.out.println("\n----- BANK MENU -----");
			System.out.println("1. Open Saving Account");
			System.out.println("2. Open Current Account");
			System.out.println("3. Display Account Summary");
			System.out.println("4. Deposit");
			System.out.println("5. Withdraw");
			System.out.println("6. Exit");

			System.out.print("Enter choice : ");
		 	int choice = sc.nextInt();

			switch (choice) {
			case 1:
				if (count < accounts.length) {
					System.out.print("Enter account number : ");
					int accNo = sc.nextInt();
					System.out.print("Enter balance : ");
					double balance = sc.nextDouble();
					sc.nextLine();
					System.out.print("Enter customer name : ");
					String name = sc.nextLine();
					System.out.print("Enter phone number : ");
					String phone = sc.nextLine();
					System.out.print("Enter interest rate : ");
					double rate = sc.nextDouble();

					try {
						BankAccount account = new SavingAccount(accNo, balance, name, phone, rate);
						validateDuplicateAccount(accounts,account,count);
						accounts[count]=account;
						count++;
						System.out.println("Saving account opened successfully...");
					} catch (Exception e) {
						System.out.println(e);
					}
				}
				else {
					System.out.println("Bank account limit reached...");
				}
				break;

			case 2:

				if (count < accounts.length) {

					System.out.print("Enter account number : ");
					int accNo = sc.nextInt();

					System.out.print("Enter balance : ");
					double balance = sc.nextDouble();

					sc.nextLine();

					System.out.print("Enter customer name : ");
					String name = sc.nextLine();

					System.out.print("Enter phone number : ");
					String phone = sc.nextLine();

					System.out.print("Enter overdraft limit : ");
					double overdraft = sc.nextDouble();

					try {
						BankAccount account = new CurrentAccount(accNo, balance, name, phone, overdraft);
						validateDuplicateAccount(accounts,account,count);
						accounts[count]=account;
						count++;
						System.out.println("Current account opened successfully...");
					} catch (Exception e) {
						System.out.println(e);
					}
				}

				else {

					System.out.println("Bank account limit reached...");
				}

				break;

			case 3:

				System.out.print("Enter account number : ");
				int searchAccNo = sc.nextInt();

				boolean found = false;

				for (int i = 0; i < count; i++) {

					if (accounts[i].getAccountNo() == searchAccNo) {

						System.out.println(accounts[i].getAccountSummary());

						found = true;

						break;
					}
				}

				if (!found) {

					System.out.println("Account not found...");
				}

				break;

			case 4:

				System.out.print("Enter account number : ");
				int depAccNo = sc.nextInt();
				System.out.print("Enter amount : ");
				double depAmount = sc.nextDouble();

				found = false;
				try {
					for (int i = 0; i < count; i++) {
						if (accounts[i].getAccountNo() == depAccNo) {
							accounts[i].deposit(depAmount);
							found = true;
							break;
						}
					}
					if (!found) {
						System.out.println("Account not found...");
					}
				} catch (Exception e) {
					System.out.println(e);
				}

				break;

			case 5:

				System.out.print("Enter account number : ");
				int wdAccNo = sc.nextInt();

				System.out.print("Enter amount : ");
				double wdAmount = sc.nextDouble();

				found = false;

				try {
				for (int i = 0; i < count; i++) {
					if (accounts[i].getAccountNo() == wdAccNo) {
							accounts[i].withdraw(wdAmount);
							found = true;
							break;
					}
				}
				if (!found) {
					System.out.println("Account not found...");
				}
				}catch(Exception e) {
					System.out.println(e.getMessage());
					}
			
				
				break;

			case 6:
				exit = true;
				System.out.println("Thank you...");
				break;

			default:
				System.out.println("Invalid choice...");
			}
		}
		sc.close();
	}
}