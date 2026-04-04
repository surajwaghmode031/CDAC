// 13:Check whether the number is palindrome or not?

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
    if(num==reverse)
    {
        cout<<num<<" is palindrome.";

    }else
    {
        cout<<num<<" is not palindrome.";
    }
    return 0;
};
