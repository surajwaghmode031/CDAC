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
		double currentBalance = getBalance();
		if(amount<=0) {
			throw new IllegalArgumentException("withDraw Amount Must Be greter than 0");
		}
		else if (currentBalance -amount<= 1000) {
			 throw new RuntimeException("Cannot withdraw! Minimum balance of ₹1000 must be maintained.");
		} else if ((currentBalance - 1000) >= amount) {
			currentBalance -= amount;
			 System.out.println("Withdrawal successful. Remaining balance: " + getBalance());
		}
	}
}
	