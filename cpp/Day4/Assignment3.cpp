// 3.1. Construct a class Employee with following members using private access
// specifies:
//  Employee Id integer
//  Employee Name string
//  Basic Salary double
//  HRA double
//  Medical double=1000
//  PF double
// PT double
//  Net Salary double
//  Gross Salary double
// Please use following expressions for calculations://Note:Don't accept HRA,PF PT from user
//  * HRA = 50% of Basic Salary
// * PF = 12% of Basic Salary
// * PT = Rs. 200

// 3.2. Write methods to display the details of an employee and calculate the gross
// and net salary.
// * Goss Salary = Basic Salary + HRA + Medical
// * Net Salary = Gross Salary – (PT + PF)

// Create Object of employee class and assign values and display Details.

#include<iostream>
#include<string>
using namespace std;

class Employee {

private:
    int empid;
    string name;
    double basic_salary;
    double hra;
    double medical;
    double pf;
    double pt;
    double gross_salary;
    double netsalary;

public:
    // Default constructor
    Employee() {
        empid = 0;
        name = "null";
        basic_salary = 0;
        hra = 0;
        medical = 1000;
        pf = 0;
        pt = 200;
        gross_salary = 0;
        netsalary = 0;
    }

    // Input function
    void setter() {
        cout << "Enter Employee ID: ";
        cin >> empid;

        cout << "Enter Employee Name: ";
        cin.ignore();
        getline(cin, name);

        cout << "Enter Basic Salary: ";
        cin >> basic_salary;
    }

    // Calculation function
    void calculate() {
        hra = basic_salary * 0.50;   // 50% HRA
        pf = basic_salary * 0.12;    // 12% PF
        // PT already fixed = 200

        gross_salary = basic_salary + hra + medical;
        netsalary = gross_salary - (pf + pt);
    }

    // Display function
    void display() {
        cout << "\n------ Employee Details ------" << endl;
        cout << "Name: " << name << endl;
        cout << "Employee ID: " << empid << endl;
        cout << "Basic Salary: " << basic_salary << endl;
        cout << "HRA: " << hra << endl;
        cout << "Medical: " << medical << endl;
        cout << "PF: " << pf << endl;
        cout << "PT: " << pt << endl;
        cout << "Gross Salary: " << gross_salary << endl;
        cout << "Net Salary: " << netsalary << endl;
    }
};

int main() {
    Employee e1;
    e1.setter();
    e1.calculate();
    e1.display();
    return 0;
}