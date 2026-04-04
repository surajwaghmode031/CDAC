package com.Bank.exception;
@SuppressWarnings("serial")
public class insufficientBalanceException extends Exception {
	public insufficientBalanceException(String message) {
		super(message);
	}
}