package com.validation;

import tester.*;
import com.core.BankAccount;
import com.core.CurrentAccount;
import com.core.SavingAccount;
import com.exception.AccountNotFoundException;

public class Validation {
	public static void savingAccountValidation(BankAccount[] accounts,int saNumber) throws AccountNotFoundException {
		for(BankAccount b: accounts) {
			if(b instanceof SavingAccount) {
				if( b!=null && b.getAccountNumber()==saNumber) {
        			throw new AccountNotFoundException("this saving account already exist....");
        		}
			}
		}
	}
			
	public static void currentAccountValidation(BankAccount[] accounts,int caNumber) throws AccountNotFoundException {
		     for(BankAccount b : accounts) {
			if(b instanceof CurrentAccount) {
				if( b!=null && b.getAccountNumber()==caNumber) {
        			throw new AccountNotFoundException("this current account already exist....");
        		}
		}
	}

}
}
