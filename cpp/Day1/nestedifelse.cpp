//18:Write a program to find greatest of three numbers using nested if-else.



#include <iostream>
using namespace std;

int main()
 {
    int n1,n2,n3;
    cout << "Enter a numbers: "<<endl;
    cin >> n1>>n2>>n3;
    if(n1>n2)
    {
        if(n1>n3)
        {
        cout<<n1<<" is greter";
        }else 
        {
            cout<<n3<<" is greter.";
        }
    }else if(n2>n3)
    {
        cout<<n2<<" is greter.";
    }else
    {
        cout<<n3<<" is greter.";
    }
    return 0;
 };