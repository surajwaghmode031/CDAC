// 1: Create an application for storing int values in vector.
// Create menu drivin app for following menu;
// 1:add 2:show all 3:search 4:sort 5:reverse 6:clear

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> nums;
    int choice;

    do {
        cout << "\n1. Add\n2. Show All\n3. Search\n4. Sort\n5. Reverse\n6. Clear\n7. Exit\nEnter choice: ";
        cin >> choice;

        switch (choice) {
        case 1: {
            int val;
            cout << "Enter value to add: ";
            cin >> val;
            nums.push_back(val);
            break;
        }
        case 2: {
            if (nums.empty()) {
                cout << "Vector is empty.\n";
            } else {
                cout << "Elements: ";
                for (int n : nums) cout << n << " ";
                cout << endl;
            }
            break;
        }
        case 3: {
            int key;
            cout << "Enter value to search: ";
            cin >> key;
            auto it = find(nums.begin(), nums.end(), key);
            if (it != nums.end())
                cout << "Found at position: " << (it - nums.begin()) << endl;
            else
                cout << "Not found.\n";
            break;
        }
        case 4: {
            sort(nums.begin(), nums.end());
            cout << "Sorted.\n";
            break;
        }
        case 5: {
            reverse(nums.begin(), nums.end());
            cout << "Reversed.\n";
            break;
        }
        case 6: {
            nums.clear();
            cout << "Cleared.\n";
            break;
        }
        case 7: {
            cout << "Exiting...\n";
            break;
        }
        default:
            cout << "Invalid choice.\n";
        }

    } while (choice != 7);

    return 0;
}
