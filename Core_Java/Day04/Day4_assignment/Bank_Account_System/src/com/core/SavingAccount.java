package com.core;

public class SavingAccount extends BankAccount {
  private double interestRate ;

  public SavingAccount(int accountNumber, double balance, String customerName, String phoneNumber, double interestRate) {
	super(accountNumber, balance, customerName, phoneNumber);
	this.interestRate = interestRate;
  }
public void applyInterest() {
	
	double interest=getBalance()*(interestRate/100);
	double i=getBalance()+interest;
	setBalance(i);
	System.out.println("interestRate applysuccessfully");
}


}
