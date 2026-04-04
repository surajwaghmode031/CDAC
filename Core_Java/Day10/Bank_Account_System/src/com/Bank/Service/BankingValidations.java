package com.Bank.Service;

import com.Bank.core.*;
import com.Bank.exception.*;

public class BankingValidations {

    public static BankAccount validateAllInputs(
            int accNo, double initBalance, String name, String phone,
            AccountType type, double extraParam,
            BankAccount[] accounts) throws insufficientBalanceException, BankException {

        // 1️⃣ Check duplicate account number (based on equals)
        BankAccount temp = new SavingAccount(accNo, initBalance, name, phone, extraParam);
        for (BankAccount b : accounts) {
            if (b != null && b.equals(temp))
                throw new BankException("Duplicate Account Number Found!");
        }

        // 2️⃣ Check specific rules using equals()
        if (type.equals(AccountType.SAVING)) {
            if (initBalance < SavingAccount.MIN_BAL)
                throw new insufficientBalanceException("Initial balance below minimum for saving account!");
            return new SavingAccount(accNo, initBalance, name, phone, extraParam);
        } else if (type.equals(AccountType.CURRENT)) {
            return new CurrentAccount(accNo, initBalance, name, phone, extraParam);
        }


        // 3️⃣ Default case
        throw new BankException("Invalid account type!");
    }
}
