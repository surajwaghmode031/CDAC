// 1. Array Input & Output
#include <iostream>
using namespace std;

int main() 
{
  int n;
   cout << "Enter number of elements: ";
   cin >> n;
   int arr[n];
   cout << "Enter elements:\n";
   for (int i = 0; i < n; i++)
   cin >> arr[i];
   cout << "Array elements are:\n";
   for (int i = 0; i < n; i++)
    cout << arr[i] << " ";
   cout << endl;
   return 0;
}
