package com.Bank.core;

public class CurrentAccount extends BankAccount{
     private double overdraftLimit;

	public CurrentAccount(int accountNumber, double balance, String name, String phoneNumber, double overdraftLimit) {
		super(accountNumber, balance, name, phoneNumber);
		this.overdraftLimit = overdraftLimit;
	}
     
	public void useOverdraftFacility(double amount) {
		if (amount<=overdraftLimit) {
			setBalance(getBalance()-amount);
			  System.out.println("Overdraft used: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
		}
	}
	
