//Write a program to find factorial of a given number. ex:no5  fact=5*4*3*2*1=120


 #include<iostream>
using namespace std;
int main()
{
    int num,i,fact=1;
    cout<<"Enter number:"<<endl;
    cin>>num;

    for(i=1;i<=num;i++)
    {
         fact=fact*i; 
    }
    cout<<"Factorial of "<<num << " is "<<fact;

    return 0;
};