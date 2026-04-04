//10:Write a program to find m to the power n. m=3 and n=4 so 3*3*3*3

#include<iostream>
using namespace std;
int main()
{
    int num,power,i;
    cout<<"Enter the number:";
    cin>>num;
    cout<<"Enter tne power:";
    cin>>power;

    int result=num;
    for(i=1;i<power;i++) //i=2;i<=power;i++
    {
        result*=num;
    }
    cout<<"a "<<num<<" to the power "<<power<< " is equal to "<<result;

    return 0;

}