// 2: Create an application for storing user information in vector.
// (Hint:User class with data member userid,name,email,pwd)
// Create Menu Driven app
// 1:add user
// 2:display all users
// 3:search user
// 4:change pwd
// 5:delete all

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class User {
    int userid;
    string name;
    string email;
    string pwd;

public:
    User(int id, string n, string e, string p) : userid(id), name(n), email(e), pwd(p) {}

    int getId() const {
        return userid;
    }

    string getEmail() const {
        return email;
    }

    void display() const {
        cout << "\nUserID: " << userid << "\nName: " << name << "\nEmail: " << email << endl;
    }

    void changePassword(string newPwd) {
        pwd = newPwd;
    }
};

int main() {
    vector<User> users;
    int choice;

    do {
        cout << "\n1. Add User\n2. Display All Users\n3. Search User by ID\n4. Change Password\n5. Delete All Users\n6. Exit\nEnter choice: ";
        cin >> choice;

        switch (choice) {
        case 1: {
            int id;
            string name, email, pwd;
            cout << "Enter UserID: ";
            cin >> id;
            cin.ignore();
            cout << "Enter Name: ";
            getline(cin, name);
            cout << "Enter Email: ";
            getline(cin, email);
            cout << "Enter Password: ";
            getline(cin, pwd);
            users.push_back(User(id, name, email, pwd));
            break;
        }

        case 2: {
            if (users.empty()) {
                cout << "No users available.\n";
            } else {
                for (const auto& u : users)
                    u.display();
            }
            break;
        }

        case 3: {
            int id;
            cout << "Enter UserID to search: ";
            cin >> id;
            bool found = false;
            for (const auto& u : users) {
                if (u.getId() == id) {
                    u.display();
                    found = true;
                    break;
                }
            }
            if (!found)
                cout << "User not found.\n";
            break;
        }

        case 4: {
            int id;
            string newPwd;
            cout << "Enter UserID to change password: ";
            cin >> id;
            cin.ignore();
            cout << "Enter new password: ";
            getline(cin, newPwd);
            bool found = false;
            for (auto& u : users) {
                if (u.getId() == id) {
                    u.changePassword(newPwd);
                    cout << "Password updated.\n";
                    found = true;
                    break;
                }
            }
            if (!found)
                cout << "User not found.\n";
            break;
        }

        case 5: {
            users.clear();
            cout << "All users deleted.\n";
            break;
        }

        case 6:
            cout << "Exiting...\n";
            break;

        default:
            cout << "Invalid choice.\n";
        }

    } while (choice != 6);

    return 0;
}
