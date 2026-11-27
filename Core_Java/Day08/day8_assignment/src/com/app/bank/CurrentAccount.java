package com.app.bank;

import static com.app.utils.ValidationRules.*;

import com.app.exceptions.InsufficientBalanceException;
import com.app.exceptions.validateAmountException;
public class CurrentAccount extends BankAccount {
	private double overdraftLimit;
	

	public CurrentAccount(int accountNo, double balance, String customerName, String phoneNumber,double overdraftLimit) {
		super(accountNo, balance, customerName, phoneNumber);
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
		return "CurrentAccount ["+super.getAccountSummary()+"overdraftLimit=" + overdraftLimit + "]";
	}


	@Override
	public void withdraw(double amount) throws InsufficientBalanceException, validateAmountException {
		validateAmount(amount,"withdraw");
		 if(getBalance()-amount<0){
			 useOverdraftFacility(amount);
			 }else {
				 setBalance(getBalance()-amount);
				 System.out.println("amount " + amount + " withdraw successfully.....");
		}

	}


	private void useOverdraftFacility(double amount) throws InsufficientBalanceException {
		if(getBalance()-amount>=(-overdraftLimit)) {
			setBalance(getBalance()-amount);
			System.out.println("amount " + amount + " withdraw successfully using overdraftLimit...");
		}else {
			validateWithdraw(getBalance(),amount);
		}
	}

}
