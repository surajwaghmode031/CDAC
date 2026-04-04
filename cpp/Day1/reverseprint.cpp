//15: Write a  program to enter a number and print its reverse.



#include<iostream>
using namespace std;
int main()
{
 int num,reverse=0;
    cout<<"Enter number :";
    cin>>num;
    int n=num;
    while(n!=0)
    {
        int reminder=n%10;
        reverse=(reverse*10)+reminder;
        n/=10;
    }
    cout<<" the reverse of "<<num<<" is "<<reverse;
    return 0;
};