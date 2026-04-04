// 4: Create an application using map for storing key and value
// key:int
// value:Account type
// Create Account class with actid, name, balance
// Create Menu driven app
// 1:Add Account
// 2:Display all
// 3:Search account by actid
// 4:Remove all

#include <iostream>
#include <map>
#include <string>
using namespace std;

class Account {
    int actid;
    string name;
    double balance;

public:
    Account() {}
    Account(int id, string n, double bal) : actid(id), name(n), balance(bal) {}

    int getActId() const {
        return actid;
    }

    void display() const {
        cout << "\nAccount ID: " << actid
             << "\nName: " << name
             << "\nBalance: " << balance << endl;
    }
};

int main() {
    map<int, Account> accounts;
    int choice;

    do {
        cout << "\n1. Add Account\n2. Display All\n3. Search Account by actid\n4. Remove All\n5. Exit\nEnter choice: ";
        cin >> choice;

        switch (choice) {
        case 1: {
            int id;
            string name;
            double bal;
            cout << "Enter Account ID: ";
            cin >> id;
            cin.ignore();
            cout << "Enter Name: ";
            getline(cin, name);
            cout << "Enter Balance: ";
            cin >> bal;
            accounts[id] = Account(id, name, bal);
            break;
        }

        case 2: {
            if (accounts.empty()) {
                cout << "No accounts available.\n";
            } else {
                for (const auto& pair : accounts) {
                    pair.second.display();
                }
            }
            break;
        }

        case 3: {
            int id;
            cout << "Enter Account ID to search: ";
            cin >> id;
            auto it = accounts.find(id);
            if (it != accounts.end()) {
                it->second.display();
            } else {
                cout << "Account not found.\n";
            }
            break;
        }

        case 4: {
            accounts.clear();
            cout << "All accounts removed.\n";
            break;
        }

        case 5:
            cout << "Exiting...\n";
            break;

        default:
            cout << "Invalid choice.\n";
        }

    } while (choice != 5);

    return 0;
}
