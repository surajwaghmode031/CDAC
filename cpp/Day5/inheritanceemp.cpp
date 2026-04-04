// 1 Solve this.
// Fresh business scenario to apply inheritance , polymorphism   to emp based organization scenario.

// Create Emp based organization structure --- Emp , Mgr , Worker


// 1.1 Emp state--- id(int), name, deptId , basicSalary(double)
// Accept all of above in constructor arguments.

// Methods ---
// 1.2. compute net salary ---ret 0
// (eg : public double computeNetSalary(){return 0;})

// 1.2 Mgr state  ---id,name,basic,deptId , perfBonus
// Add suitable constructor
// Methods ----
// 1. compute net salary (formula: basic+perfBonus) -- override computeNetSalary


// 1.3 Worker state  --id,name,basic,deptId,hoursWorked,hourlyRate
// Methods : 
// 1.  compute net salary (formula:  = basic+(hoursWorked*hourlyRate) --override computeNetSalary
// 2. get hrlyRate of the worker  -- add a new method to return hourly rate of a worker.(getter)

// Create suitable array to store organization details.
// Provide following options
// 1. Hire Manager
// I/P : all manager details

// 2. Hire Worker  
// I/P : all worker details

// 3. Display information of all employees net salary (by invoking computeNetSal), 

// 4. Exit
// ----------------------------------------------------
#include<iostream>
#include<string>
using namespace std;
class employee
{
    public:
    int empid;
    string name;
    int deptid;
    double basic_salary;

   public :
   employee(int empid,string name,double basic_salary)
        {
            this->empid=empid;
            this->name=name;
            this->basic_salary= basic_salary;
        }

        public:
        virtual double computeNetSalary()
        {

            return 0;
        }
    

};
class Manager:private employee
{
    private:
    double perbonus;

    public:
    Manager(int empid,string name,double basic_salary,double perbonus)
        {
            this->empid=empid;
            this->name=name;
            this->basic_salary= basic_salary;
            this->perbonus=perbonus;
        }
    
    double computeNetSalary() override
    {
        int a= basic_salary+perbonus;
        return a;
    }

};

class worker: public employee
{
    int Work_hr;
    double hourlyrate;

    public:
    worker(int empid,string name,double basic_salary,int Work_hr,double hourlyrate)
        {
            this->empid=empid;
            this->name=name;
            this->basic_salary= basic_salary;
            this->Work_hr=Work_hr;
        }
    
    double computeNetSalary() override
    {
        int a= basic_salary+(Work_hr*hourlyrate);
        return a;
    }
    double gethourlyrate()
    {
         return hourlyrate;
    }

}