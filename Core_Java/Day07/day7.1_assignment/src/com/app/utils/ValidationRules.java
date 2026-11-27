package com.app.utils;
import com.app.exceptions.InsufficientBalanceException;

public class ValidationRules {

	public static void validateWithdraw(double balance, double amount) throws InsufficientBalanceException {
		if ((balance - amount) < 0) {
			throw new InsufficientBalanceException("Insufficient balance...");
		}
	}
	


}