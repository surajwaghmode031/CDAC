// 2. Sum & Average of Array
#include <iostream>
using namespace std;

int main() {
    int n;
    float sum = 0;
    cout << "Enter number of students: ";
    cin >> n;
    float marks[n];
    cout << "Enter marks:\n";
    for (int i = 0; i < n; i++)
     {
       cin >> marks[i];
       sum += marks[i];
    }
    cout << "Total Marks: " << sum << endl;
    cout << "Average Marks: " << (sum / n) << endl;
    return 0;
}
