// 8. Second Largest Element
#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    if (n < 2) {
        cout << "Array must have at least 2 elements." << endl;
        return 0;
    }

    int arr[n];
    cout << "Enter elements:\n";
    for (int i = 0; i < n; i++) cin >> arr[i];

    int first = arr[0];
    int second = -1; // marker for "not found yet"

    // find first and second
    for (int i = 1; i < n; i++) {
        if (arr[i] > first) {
            second = first;
            first = arr[i];
        } else if (arr[i] < first) {
            if (second == -1 || arr[i] > second) {
                second = arr[i];
            }
        }
    }

    if (second == -1)
        cout << "No second largest element." << endl;
    else
        cout << "Second largest element: " << second << endl;

    return 0;
}
