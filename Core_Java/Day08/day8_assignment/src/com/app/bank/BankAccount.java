package com.app.bank;

import static com.app.utils.ValidationRules.*;
import com.app.exceptions.InsufficientBalanceException;
import com.app.exceptions.validateAmountException;

public abstract class BankAccount {
	private int accountNo;
	private double balance;
	private String customerName;
	private String phoneNumber;
	
	
	public BankAccount(int accountNo, double balance, String customerName, String phoneNumber) {
		this.accountNo = accountNo;
		this.balance = balance;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getAccountNo() {
		return accountNo;
	}
	
	
	public void deposit(double amount) throws InsufficientBalanceException, validateAmountException {
		validateAmount(amount,"deposite");
		balance+=amount;
		System.out.println("amount deposite successfully...");
		
	}
	
	// abstract method
	public abstract void withdraw(double amount) throws InsufficientBalanceException, validateAmountException;


	
	public String getAccountSummary() {
		return "accountNo=" + accountNo + ", balance=" + balance + ", customerName=" + customerName+ ", phoneNumber=" + phoneNumber;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BankAccount) {
			BankAccount bankAccount=(BankAccount)obj;
			return accountNo == bankAccount.accountNo;
		}
		return false;
	}
	
	
	
			
			
	
	
	

}
