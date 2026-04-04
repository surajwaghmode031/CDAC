package com.tester;
import com.core.*;
public class TestAccount {

	public static void main(String[] args) {
	//int accountNumber, double balance, String name, String phoneNumber, double interestRate
		//upcasting , indirect reference
		BankAccount b1 =  new SavingAccount(100,5000,"sourabh","123456789",5);
		b1.deposite(1000);
		//downcasting
		 ((SavingAccount) b1).applyInterest();
		 b1.withdrawAmount(1000);
		System.out.println( b1.getAccountSummary());
		 
		SavingAccount sa1= new SavingAccount(101,7000,"suraj","123456789",4);
		sa1.deposite(500);
		sa1.applyInterest();
		sa1.withdrawAmount(100);
		System.out.println( sa1.getAccountSummary());
		
		CurrentAccount ca1= new CurrentAccount(12,10000,"sunil","11122334455",5000);
		ca1.deposite(5000);
		ca1.useOverdraftFacility(3000);
		ca1.withdrawAmount(18000);
		System.out.println( ca1.getAccountSummary());
		
	}

}
