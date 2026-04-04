//14:Write a  program to find sum of all even and odd numbers between 1 to n. 

#include<iostream>
using namespace std;
int main()
{
    int n,i=1,evensum=0,oddsum=0;
    cout<<"Enter the range:";
    cin>>n;
    
    for(i;i<=n;i++)
    {
        if(i%2==0)
        {
            evensum=evensum+i;
        }else
        {
            oddsum=oddsum+i;
        }
    }
    cout<<"sum of even number between 1 to "<<n<<" is "<<evensum<<endl;
    cout<<"sum of odd number between 1 to "<<n<<" is "<<oddsum;
    return 0;
};