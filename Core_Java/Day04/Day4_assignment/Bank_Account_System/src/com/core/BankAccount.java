package com.core;

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
	public void depositeAmount(double amount) {
	    double a=0;
		if(amount>0) {
			 a = getBalance()+amount;
		     setBalance(a);
		     System.out.println("Amount deposite successfully...!");
		}
		else
		System.out.println("Enter valid Amount..!");
	}
	public void withdrawAmount(double w) {
		if(w > 0 && getBalance()>w) {
			double d=getBalance()-w;
			setBalance(d);
		     System.out.println("Amount withdraw successfully...!");
		}else
			System.out.println("Enter valid Amount..!");  
			
		}
	public String getAccountSummary() {
		return  " accountNumber="+ accountNumber+"customerName="+customerName +"balance="+balance+"phoneNumber="+phoneNumber;
		
	}
		
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}




