//17:Write a program to check entered number is Armstrong number or not.


#include <iostream>
using namespace std;

int main()
 {
    int num, originalnum, remainder, result = 0, n = 0;
    cout << "Enter a number: ";
    cin >> num;

    originalnum = num;


    while (originalnum != 0) // for to calculatr number of digits(power)
    {
        originalnum /= 10;
        ++n;
    }

    originalnum = num; 

    while (originalnum != 0)   // sum
    {
        remainder = originalnum % 10;

        int power = 1;
        for (int i = 0; i < n; ++i) 
        {
            power *= remainder;
        }

        result += power;
        originalnum /= 10;      // next digit
    }

    if (result == num)
        cout << num << " is an armstrong number." << endl;
    else
        cout << num << " is not an armstrong number." << endl;

    return 0;
 };