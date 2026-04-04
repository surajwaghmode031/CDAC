// 2: Create cpp application for bank account handling.
// 2.1. Create a class BankAccount -- acct no(int), customer name(string), balance(double)
// Add constr. (2 constrs : first to accept all details )
// 2.2 Add Business logic methods
// Methods
// public void withdraw(double amt)
// public void deposit(double amt)
// 2.3: Create object of account class and test withdraw and deposit methods.

#include <iostream>
#include <string>
using namespace std;

class BankAccount {
private:
    int accountNo;
    string customerName;
    double balance;

public:
    // Parameterized constructor
    BankAccount(int acct, string name, double bal) {
        accountNo = acct;
        customerName = name;
        balance = bal;
    }

    // Default constructor
    BankAccount() {
        accountNo = 0;
        customerName = "NA";
        balance = 0.0;
    }

    // Deposit method
    void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            cout << "Amount deposited successfully!" << endl;
        } else {
            cout << "Invalid deposit amount!" << endl;
        }
    }

    // Withdraw method
    void withdraw(double amt) {
        if (amt <= 0) {
            cout << "Invalid withdrawal amount!" << endl;
        }
        else if (amt > balance) {
            cout << "Insufficient balance!" << endl;
        }
        else {
            balance -= amt;
            cout << "Amount withdrawn successfully!" << endl;
        }
    }

    // Display method
    void display() {
        cout << "\n------ Account Details ------" << endl;
        cout << "Account No: " << accountNo << endl;
        cout << "Customer Name: " << customerName << endl;
        cout << "Balance: " << balance << endl;
    }
};

int main() {
    BankAccount acc(101, "John Doe", 1000.0);

    acc.display();

    acc.deposit(500);
    acc.display();

    acc.withdraw(300);
    acc.display();

    acc.withdraw(1500);
    acc.display();

    return 0;
}