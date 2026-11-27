package com.app.utils;

import com.app.bank.BankAccount;
import com.app.exceptions.*;

public class ValidationRules {
	
	public static void validateWithdraw(double balance, double amount) throws InsufficientBalanceException {
		if(balance-amount<0) {
			throw new InsufficientBalanceException("Insufficient balance...");
		}
		
	}
	
	public static void validateAmount(double amount, String msg) throws  validateAmountException {
		if(amount<=0) {
			throw new validateAmountException(msg+"Amount should be gretr than 0");
		}
	}
	
	public static void validateDuplicateAccount(BankAccount[]bankAccounts,BankAccount acc,int count) throws DuplicateAccountException {
		for(int i=0;i<count;i++) {
			if(bankAccounts[i].equals(acc)) {
				throw new DuplicateAccountException("This account already exists. We can't create duplicate account...");
			}
		}
	}
}
