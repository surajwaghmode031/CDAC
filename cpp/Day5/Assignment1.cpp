// 1. Fresh business scenario to apply inheritance , polymorphism to emp based organization scenario.

#include <iostream>
#include <string>
using namespace std;

// 1.1 Emp base class
class Emp {
protected:
    int id;
    string name;
    int deptId;
    double basicSalary;

public:
    Emp(int id, string name, int deptId, double basicSalary)
        : id(id), name(name), deptId(deptId), basicSalary(basicSalary) {}

    virtual double computeNetSalary() {
        return 0;
    }

    virtual void displayInfo() {
        cout << "\nID: " << id
             << "\nName: " << name
             << "\nDepartment ID: " << deptId
             << "\nBasic Salary: " << basicSalary
             << "\nNet Salary: " << computeNetSalary() << endl;
    }

    virtual ~Emp() {}
};

// 1.2 Manager class
class Mgr : public Emp {
    double perfBonus;

public:
    Mgr(int id, string name, int deptId, double basicSalary, double perfBonus)
        : Emp(id, name, deptId, basicSalary), perfBonus(perfBonus) {}

    double computeNetSalary() override {
        return basicSalary + perfBonus;
    }

    void displayInfo() override {
        cout << "\n[Manager]";
        Emp::displayInfo();
        cout << "Performance Bonus: " << perfBonus << endl;
    }
};

// 1.3 Worker class
class Worker : public Emp {
    int hoursWorked;
    double hourlyRate;

public:
    Worker(int id, string name, int deptId, double basicSalary, int hoursWorked, double hourlyRate)
        : Emp(id, name, deptId, basicSalary), hoursWorked(hoursWorked), hourlyRate(hourlyRate) {}

    double computeNetSalary() override {
        return basicSalary + (hoursWorked * hourlyRate);
    }

    double getHourlyRate() const {
        return hourlyRate;
    }

    void displayInfo() override {
        cout << "\n[Worker]";
        Emp::displayInfo();
        cout << "Hours Worked: " << hoursWorked
             << "\nHourly Rate: " << hourlyRate << endl;
    }
};

int main() {
    const int MAX_EMP = 100;
    Emp* org[MAX_EMP];
    int empCount = 0;

    int choice;

    do {
        cout << "\n=========== Employee Management Menu ===========\n";
        cout << "1. Hire Manager\n";
        cout << "2. Hire Worker\n";
        cout << "3. Display All Employees Info with Net Salary\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1: {
            if (empCount >= MAX_EMP) {
                cout << "Cannot hire more employees.\n";
                break;
            }
            int id, deptId;
            string name;
            double basic, bonus;

            cout << "Enter Manager ID: ";
            cin >> id;
            cout << "Enter Name: ";
            cin.ignore();
            getline(cin, name);
            cout << "Enter Department ID: ";
            cin >> deptId;
            cout << "Enter Basic Salary: ";
            cin >> basic;
            cout << "Enter Performance Bonus: ";
            cin >> bonus;

            org[empCount++] = new Mgr(id, name, deptId, basic, bonus);
            cout << "Manager hired successfully.\n";
            break;
        }

        case 2: {
            if (empCount >= MAX_EMP) {
                cout << "Cannot hire more employees.\n";
                break;
            }
            int id, deptId, hours;
            string name;
            double basic, rate;

            cout << "Enter Worker ID: ";
            cin >> id;
            cout << "Enter Name: ";
            cin.ignore();
            getline(cin, name);
            cout << "Enter Department ID: ";
            cin >> deptId;
            cout << "Enter Basic Salary: ";
            cin >> basic;
            cout << "Enter Hours Worked: ";
            cin >> hours;
            cout << "Enter Hourly Rate: ";
            cin >> rate;

            org[empCount++] = new Worker(id, name, deptId, basic, hours, rate);
            cout << "Worker hired successfully.\n";
            break;
        }

        case 3: {
            if (empCount == 0) {
                cout << "No employees to display.\n";
            } else {
                cout << "\n--- All Employees ---\n";
                for (int i = 0; i < empCount; i++) {
                    org[i]->displayInfo();
                    cout << "---------------------------------\n";
                }
            }
            break;
        }

        case 4:
            cout << "Exiting program...\n";
            break;

        default:
            cout << "Invalid choice. Please try again.\n";
        }

    } while (choice != 4);

    // Free memory
    for (int i = 0; i < empCount; i++) {
        delete org[i];
    }

    return 0;
}
