// 1:Write a program to create student class with data members rollno, marks1,mark2,mark3.
// Accept data (acceptInfo()) and display  using display member function.
// Also display total,percentage and grade.

#include<iostream>
#include<iomanip>
using namespace std;
class student{
    int rollno;
    int marks1;
    int marks2;
    int marks3;
    public:
    student(){
        rollno=0;
        marks1=0;
        marks2=0;
        marks3=0;
    }
    void setter(int roll,int marks1,int marks2,int marks3){
        this->rollno=roll;
        this->marks1=marks1;
        this->marks2=marks2;
        this->marks3=marks3;
    }
   void display(){
    cout<<rollno<<endl;
    cout<<marks1<<endl;
    cout<<marks2<<endl;
    cout<<marks3<<endl;
   }
   void totalmarks(){
    double total=marks1+marks2+marks3;
    cout<<"total marks :"<<total<<endl;

    double percentage =(total/300)*100;
        cout << fixed << setprecision(2);

    cout<<"percentage :"<<percentage<<endl;

    if(percentage <=50){
        cout<<"grade c";
    }else if (percentage <=80){
        cout<<"grade b";
    }else {
        cout<<"grade a";
    }

   }
};
int main()
{
    student s1;
    s1.setter(77,55,65,98);
    s1.display();
    s1.totalmarks();

  return 0;  
}
