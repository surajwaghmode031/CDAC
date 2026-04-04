// 3:Consider that payroll software needs to be developed for computerization of
// operations of an ABC organization. The organization has employees.
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



#include <iostream>
using namespace std;
#include <string>
class employee
{
private:
    int empid ;
    string emp_Name;
    double basic_salary;
    double HRA ;
    double  medical;
    double PF;
    double PT ; 
    double net_salary ;
    double gross_salary;

    public:
    employee()
        {
        cout<<"----------default constructor----------"<<endl;
         empid= 1;
        emp_Name= "default name";
        basic_salary= 60000;
        HRA =0;
        medical= 1000;
        PF= 0;
        PT= 0; 
        net_salary= 0;
        gross_salary=0 ;

        }
        void salaries()
        {
            HRA = 0.50 * basic_salary;
        PF = 0.12 * basic_salary;
        PT = 200;
        medical = 1000;
       gross_salary = basic_salary + HRA + medical;
        net_salary = gross_salary -(PF +PT);
        }
    
    void display()
    {
        cout<<"---------------Employee Datiles---------------"<<endl;
        cout<<"Employee id       :"<<empid<<endl;
        cout<<"Employee Name     :"<<emp_Name<<endl;
        cout<<"Basic salary      :"<<basic_salary<<endl;
        cout<<"HRA               :"<<HRA<<endl;
        cout<<"PF                :"<<PF<<endl;
        cout<<"PT                :"<<PT<<endl;
        cout<<"Net salary        :"<<net_salary<<endl;
        cout<<"gross salary       :"<<gross_salary<<endl;
    }
    
};
int main()
{
    employee e1;
    e1.salaries();
    e1.display();



    return 0;
}