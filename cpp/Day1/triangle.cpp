//8. Write a  program to input angles of a triangle and check whether triangle is valid or not.



#include<iostream>
using namespace std;
int main()
{
    int a,b,c;
    cout<<"Enter Angles of triangle:"<<endl;
    cin>>a>>b>>c;
    if((a+b+c)==180)
    {
        cout<<"Tringle is valid";
    }else
    {
        cout<<"Tringle is invalid";
    }
    return 0;
};
