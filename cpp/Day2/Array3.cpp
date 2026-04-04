// 3. Find Maximum and Minimum
#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;
    int arr[n];
    cout << "Enter elements:\n";
    for (int i = 0; i < n; i++) 
    cin >> arr[i];
    int max = arr[0], min = arr[0];
    for (int i = 1; i < n; i++)
     {
      if (arr[i] > max) max = arr[i];
      if (arr[i] < min) min = arr[i];
    }
    cout << "Maximum: " << max << endl;
    cout << "Minimum: " << min << endl;
    return 0;
}
