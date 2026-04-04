package com.core;

import com.exception.BalanceOutOfBoundException;

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
			throw new BalanceOutOfBoundException("minimum 10000 amount required in bank account. you Cannot withdraw amount from account..!")
		} else if ((currentBalance - 1000) >= amount) {
			currentBalance -= amount;
			setBalance(currentBalance);
			System.out.println(" amount withdraw successfully from account..!");
		} else {
			System.out.println("Cannot withdraw amount from account..!");
		}
	}
}
	