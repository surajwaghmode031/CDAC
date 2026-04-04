//1. Write a program, which accepts two integers and an operator as a character (+ - * / ), performs the 
//corresponding operation and displays the result.



#include <iostream>
using namespace std;

int main()
 {
    int n1,n2,choice;
    cout << "Enter a two number: ";
    cin >>n1>>n2;
    do{
        cout<<"0:exit"<<endl<<"1:Addition"<<endl<<"2:substitin"<<endl<<"3:multipication"<<endl<<"4:division"<<endl;
        cout<<"Enter the choice:";
        cin>>choice;
        switch(choice)
        {
            case 1:
            cout<<"sum ="<<n1+n2<<endl;
            break;
            case 2:
            cout<<"sub="<<n1-n2<<endl;
            break;
            case 3:
            cout<<"mul ="<<n1*n2<<endl;
            break;
            case 4:
            cout<<"div="<<n1/n2<<endl;
            break;
            default:
            cout<<"invalid choice";

        }
    }while(choice!=0);

    return 0;
 };