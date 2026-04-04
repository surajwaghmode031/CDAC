// 1:Create Date class with members day,month ,year.
// Write no argument and parameterised constructor .Create two object s and initialize them using no argument and parameterised constructor
// respectively.Print date using display function.
#include<iostream>
using namespace std;
//class date
class date {
    private:
    int day;
    int month;
    int year;

    //no argument constructor,dont use data type otherwise this is going to declare new variable
    public:
    date(){
        day=0;
        month=0;
        year=0;
    }

    //parameterised constructor
    date(int day,int month,int year){
        this->day=day;
        this->month=month;
        this->year=year;
    }
    //display function
    void display(){
       cout<<day<<"-"<<month<<"-"<<year<<endl;
    }
    //setter
    void setdate(int day,int month,int year){
        this->day=day;
        this->month=month;
        this->year=year;
    }
};
int main(){
       date d1;
       d1.display();
       d1.setdate(10,10,1999);
       d1.display();
       date d2(20,2,2023);
       d2.display();

        return 0;
    }