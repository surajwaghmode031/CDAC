package com.app.bank;

import static com.app.utils.ValidationRules.*;

import com.app.exceptions.InsufficientBalanceException;
import com.app.exceptions.validateAmountException;

public class SavingAccount extends BankAccount {
	private double interestRate;
	
	
	public SavingAccount(int accountNo, double balance, String customerName, String phoneNumber, double interestRate) {
		super(accountNo, balance, customerName, phoneNumber);
		this.interestRate = interestRate;
	}


	@Override
	public String getAccountSummary() {
		return "SavingAccount ["+super.getAccountSummary()+"interestRate=" + interestRate + "]";
	}
	
	
	public void applyInterestRate() {
		double interest=(getBalance()*interestRate)/100;
		setBalance(interest);
		System.out.println("interestRate apply successfully....");
	}


	@Override
	public void withdraw(double amount) throws  validateAmountException, InsufficientBalanceException {
		validateAmount(amount,"withdraw");
		validateWithdraw(getBalance(), amount);
		setBalance(getBalance()-amount);

	}

}
