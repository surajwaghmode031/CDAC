package com.Bank.exception;

@SuppressWarnings("serial")// to remove warning
public class AccountNotFoundException extends Exception{
	public AccountNotFoundException(String message) {
		super(message);
	}
}