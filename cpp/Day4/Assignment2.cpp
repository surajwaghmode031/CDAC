// 2:Create Employee class with members id(int),name(string),dob(Date).Use above created Date class.
// Write default and parameterised constructor in Employee Class.Write accept() function to accept information and display() to display emp information.
#include<iostream>
#include<string>   
using namespace std;
struct date {
    int day;
    int month;
    int year;
};

class Employee {
    private:
    int id;
    string name;
    date dob;

    public:
    //no argument  constructor 
    Employee(){
        id=0;
        name="not given yet";
       dob.day=0;
       dob.month=0;
       dob.year=0;
    }
    //parameterised constructor
    Employee(int id,string name,int d,int month,int year){
        this ->id=id;
        this ->name=name;
        this ->dob.day=d;
        this ->dob.month=month;
        this ->dob.year=year;
    }
    void accept (){
        cout<<"----plz enter the employee details-------\n";
        cout<<"enter employee id:";
        cin>>id;
        cout<<"enter employee name:";
        cin>>name;
        cout<<"enter employee dob:";
        cout<<"enter the day: ";
        cin>>dob.day;cout<<"enter the month:";cin>>dob.month;cout<<"plz enter the year :";cin>>dob.year;
        
    }
        
    void display(){
        cout<<"--------employee details-------------\n";
        cout<<"employee id :"<<id<<endl;
        cout<<"employee name :"<<name<<endl;
        cout<<"date of birth :"<<dob.day<<"/"<<dob.month<<"/"<<dob.year<<endl;
}
};

int main(){

    Employee e1,e2(10,"waghmode",1,1,2000);
    e1.display();
    e1.accept();
    e1.display();
    e2.display();

    return 0;
}