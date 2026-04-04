//11:Check if number is a prime number or not.:

#include<iostream>
using namespace std;
int main()
{
    int num,counter=0 ;
    cout<<"Enter the number :";
    cin>>num;

    if(num<1)
    {
        cout<<num<<" is not prime number.";

    }else
    {
        for(int i=1;i<=num;i++)
        {
            if(num%i==0)
            counter++;
        }
        if(counter>2)
        {
            cout<<num<<" is not prime number.";
        }else
        {
            cout<<"is  prime number ";
        }
    }
 return 0;
};