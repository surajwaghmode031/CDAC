package com.core;

import java.util.Objects;

public class BankAccount {
  private int accountNumber;
  private double balance;
  private String name;
  private String phoneNumber;
public BankAccount(int accountNumber, double balance, String name, String phoneNumber) {
	super();
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.name = name;
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


public String getAccountSummary() {
	return "accountNumber=" + accountNumber + ", balance=" + balance + ", name=" + name + ", phoneNumber="
			+ phoneNumber;
}
public void withdrawAmount(double w) {
	if(w > 0 && getBalance()>w) {
		double d=getBalance()-w;
		setBalance(d);
	     System.out.println("Amount withdraw successfully...!");
	}else
		System.out.println("Enter valid Amount..!");  
		
	}

public void deposite(double amount) {
	  if(amount>0) {
		 double balance= getBalance()+amount;
		 setBalance(balance);
		 System.out.println("amount "+amount+" deposited successfuly");
	  }
	

	  
  }

@Override
public int hashCode() {
	return Objects.hash(accountNumber);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BankAccount other = (BankAccount) obj;
	return accountNumber == other.accountNumber;
}
}
