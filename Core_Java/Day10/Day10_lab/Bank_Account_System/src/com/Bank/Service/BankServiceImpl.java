package com.Bank.Service;

import com.Bank.core.AccountType;
import com.Bank.core.BankAccount;
import com.Bank.exception.BankException;
import com.Bank.exception.insufficientBalanceException;

public  class BankServiceImpl implements BankService {

	private BankAccount accounts[];
	private int counter;

	public BankServiceImpl(int size) {
		this.accounts = new BankAccount[size];

	}

	@Override
	public void openCurrentAccount(int accountNumber, double balance, String name, String phoneNumber, double overdraft,
			AccountType accountType) {

	}
	@Override
	public void openSavingAccount(int accountNumber, double balance, String name, String phoneNumber,
			double interestRate,AccountType saType) throws BankException, insufficientBalanceException {

		BankAccount b = BankingValidations.validateAllInputs(accountNumber, balance, name, phoneNumber, saType, interestRate,
				accounts);
		accounts[counter++] = b;
	}

	@Override
	public String accountSummary() {
		return null;
	}

}
