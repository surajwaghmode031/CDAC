package com.app.bank;

import com.app.exceptions.InsufficientBalanceException;
import static com.app.utils.ValidationRules.validateWithdraw;

import java.util.Objects;
public class BankAccount {
	private int accountNumber;
	private double balance;
	private String customerName;
	private String phoneNumber;

	public BankAccount(int accountNumber, double balance, String customerName, String phoneNumber) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}
	
	

	public int getAccountNumber() {
		return accountNumber;
	}



	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("amount deposite successfully...");
		}else {
        System.out.println("Invalid amount: Amount should be greater than 0.");
    }
	}

	public void withdraw(double amount) throws InsufficientBalanceException {

		validateWithdraw(getBalance(), amount);

		setBalance(getBalance() - amount);

		System.out.println("Amount withdrawn successfully...");
	}

	public String getAccountSummary() {
		return "accountNumber=" + accountNumber + ", balance=" + balance + ", customerName=" + customerName
				+ ", phoneNumber=" + phoneNumber;
	}



	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, balance, customerName, phoneNumber);
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BankAccount) {
			BankAccount bankAccount = (BankAccount)obj;
			return this.accountNumber==bankAccount.accountNumber;
		}
		return false;
	}
	
	
	
	

}
