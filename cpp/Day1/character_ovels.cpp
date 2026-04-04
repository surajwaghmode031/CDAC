// Accept a lowercase character from the user and check whether the character is a vowel or consonant. 
//(Hint: a, e, i, o, u are vowels)


#include<iostream>
using namespace std;
int main()
{
    char ch;
    cout<<"Enter the character:";
    cin>>ch;
    if(ch=='a' || ch=='e' || ch=='i' || ch=='o'  || ch=='u')
    {
        cout<<ch<<" is vowel character .";
    }else{
        cout<<ch<<" is consonant character .";  
  
  }
return 0;
};