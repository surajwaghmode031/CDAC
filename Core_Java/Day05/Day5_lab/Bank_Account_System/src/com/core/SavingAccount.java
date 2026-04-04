package com.core;

public class SavingAccount extends BankAccount{

	private double interestRate;

	public SavingAccount(int accountNumber, double balance, String name, String phoneNumber, double interestRate) {
		super(accountNumber, balance, name, phoneNumber);
		this.interestRate = interestRate;
	}
	
	public void applyInterest() {
		double interest= getBalance()*(interestRate/100);
		setBalance(getBalance()+interest);
		System.out.println("interestRate applysuccessfully");
	}
	@Override
	public void withdrawAmount(double amount) {
		double currentBalance = super.getBalance();
		if (currentBalance <= 1000) {
			System.out.print("Please maintain minimum balance..!");
		} else if ((currentBalance - 1000) >= amount) {
			currentBalance -= amount;
			setBalance(currentBalance);
		} else {
			System.out.println("Cannot withdraw amount from account..!");
		}
	}
}
	