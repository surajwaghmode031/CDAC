package com.Bank.Service;

import com.Bank.core.AccountType;
import com.Bank.exception.BankException;
import com.Bank.exception.insufficientBalanceException;


public interface BankService {

	public void openCurrentAccount(int accountNumber, double balance, String name, String phoneNumber,
			double overdraftLimit, AccountType accountType);

	public void openSavingAccount(int accountNumber, double balance, String name, String phoneNumber,
			double interestRate, AccountType accountType) throws BankException, insufficientBalanceException;

	public String accountSummary();
}