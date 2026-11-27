package com.app.bank;
import static com.app.utils.ValidationRules.validateWithdraw;

import com.app.exceptions.InsufficientBalanceException;
public class CurrentAccount extends BankAccount {
	private double overdraftLimit;

	public CurrentAccount(int accountNumber, double balance, String customerName, String phoneNumber,
			double overdraftLimit) {
		super(accountNumber, balance, customerName, phoneNumber);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public String getAccountSummary() {
		return "CurrentAccount [" + super.getAccountSummary() + "overdraftLimit=" + overdraftLimit + "]";
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount < 0) {
			System.out.println("Invalid amount : amount shoud be greter than 0");
		} else if ((getBalance() - amount) < 0) {
			useOverdraftFacility(amount);
		}else {
			setBalance(getBalance()-amount);
			System.out.println("amount " + amount + " withdraw successfully.....");
		}

	}

	public void useOverdraftFacility(double amount) throws InsufficientBalanceException {
		if ((getBalance() - amount) >= (-overdraftLimit)) {
			setBalance(getBalance() - amount);
			System.out.println("amount " + amount + " withdraw successfully using overdraftLimit...");
		} else {
			validateWithdraw(getBalance(),amount);
		}
	}

}
