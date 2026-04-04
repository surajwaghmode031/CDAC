//3:Write a program to swap two numbers.
#include <iostream>
using namespace std;
int main()
{
    int a,b,temp;
    cout<<" Enter the tow number :"<< endl;
    cin>>a>>b;
    cout<<"Number before swap :"<<endl<<"a= "<<a<<"\tb= "<<b<<endl;

    temp=a;
    a=b;
    b=temp;
    cout<<"Number after  swap :"<<endl<<"a= "<<a<<"\tb= "<<b;
    return 0;

};