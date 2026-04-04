// 9. Frequency of Each Element
#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;
    int arr[n], freq[n];
    cout << "Enter elements:\n";
    for (int i = 0; i < n; i++) 
    {
     cin >> arr[i];
     freq[i] = -1;
    }

    for (int i = 0; i < n; i++) {
        if (freq[i] != -1) continue;
        int count = 1;
        for (int j = i + 1; j < n; j++)
         {
         if (arr[i] == arr[j])
         {
            count++;
            freq[j] = 0;
        }
        }
        freq[i] = count;
    }
    cout << "Frequency of elements:\n";
    for (int i = 0; i < n; i++)
     {
      if (freq[i] != 0)
     cout << arr[i] << " occurs " << freq[i] << " times\n";
    }
    return 0;
}
