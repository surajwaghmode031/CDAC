// 12:Sum of series :
// 	1+2+3+….+n


#include<iostream>
using namespace std;
int main()
{
    int n,sum=0;
    cout<<"Enter last number of series :";
    cin>>n;

    for(int i=1;i<=n;i++)
    {
        sum=sum+i;
    }
    cout<<"the sum of 1st "<<n<<" natural number is "<<sum;
    return 0;

};