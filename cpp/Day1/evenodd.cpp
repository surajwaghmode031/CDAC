//4. Write a program to accept an integer and check if it is even or odd.



#include<iostream>
using namespace std;
int main()
{
int n;
cout<<" enter number :";
cin>>n;
if(n%2==0)
{
    cout<<n<<" is even number.";
}
else
cout<<n<<" is odd number.";

return 0;
};