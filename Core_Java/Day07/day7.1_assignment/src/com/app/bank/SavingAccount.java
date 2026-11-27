package com.app.bank;

public class SavingAccount extends BankAccount {
	private double interestRate;

	public SavingAccount(int accountNumber, double balance, String customerName, String phoneNumber,
			double interestRate) {
		super(accountNumber, balance, customerName, phoneNumber);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String getAccountSummary() {
		return "SavingAccount [ "+super.getAccountSummary()+ " interestRate=" + interestRate + "]";
	}
	
	public void applyInterestRate() {

		double interest = (getBalance() * interestRate) / 100;
		setBalance(interest+getBalance());
		System.out.println("interestRate apply successfully....");
	}
	
	
}
