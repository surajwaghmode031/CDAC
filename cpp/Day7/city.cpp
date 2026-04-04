// 3: Create an application using set.
// Accept name of city from user and store in set
// Create Menu drivien app
// 1:add city
// 2:display  all city
// 3: serach city

#include <iostream>
#include <set>
#include <string>
using namespace std;

int main() {
    set<string> cities;
    int choice;

    do {
        cout << "\n1. Add City\n2. Display All Cities\n3. Search City\n4. Exit\nEnter choice: ";
        cin >> choice;

        switch (choice) {
        case 1: {
            string city;
            cout << "Enter city name: ";
            cin.ignore();
            getline(cin, city);
            cities.insert(city);
            break;
        }

        case 2: {
            if (cities.empty()) {
                cout << "No cities available.\n";
            } else {
                cout << "Cities:\n";
                for (const auto& city : cities)
                    cout << city << endl;
            }
            break;
        }

        case 3: {
            string city;
            cout << "Enter city name to search: ";
            cin.ignore();
            getline(cin, city);
            if (cities.find(city) != cities.end())
                cout << "City found.\n";
            else
                cout << "City not found.\n";
            break;
        }

        case 4:
            cout << "Exiting...\n";
            break;

        default:
            cout << "Invalid choice.\n";
        }

    } while (choice != 4);

    return 0;
}
