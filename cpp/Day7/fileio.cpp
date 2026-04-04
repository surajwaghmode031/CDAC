// 5: Create an File IO application for basic operation 
// 1:Write file:accept data from user and store in file
// 2:Read file:display line by line
// 3:copy data from one file into another file

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
    int choice;
    do {
        cout << "\n1. Write to file\n2. Read from file\n3. Copy file\n4. Exit\nEnter choice: ";
        cin >> choice;
        cin.ignore();

        switch (choice) {
        case 1: {
            string filename, line;
            cout << "Enter filename to write: ";
            getline(cin, filename);
            ofstream outfile(filename, ios::app);
            if (!outfile) {
                cout << "Error opening file.\n";
                break;
            }
            cout << "Enter data (type 'END' to stop):\n";
            while (true) {
                getline(cin, line);
                if (line == "END") break;
                outfile << line << "\n";
            }
            outfile.close();
            cout << "Data written successfully.\n";
            break;
        }
        case 2: {
            string filename, line;
            cout << "Enter filename to read: ";
            getline(cin, filename);
            ifstream infile(filename);
            if (!infile) {
                cout << "Error opening file.\n";
                break;
            }
            cout << "File contents:\n";
            while (getline(infile, line)) {
                cout << line << endl;
            }
            infile.close();
            break;
        }
        case 3: {
            string sourceFile, destFile;
            cout << "Enter source filename: ";
            getline(cin, sourceFile);
            cout << "Enter destination filename: ";
            getline(cin, destFile);
            ifstream src(sourceFile);
            if (!src) {
                cout << "Error opening source file.\n";
                break;
            }
            ofstream dest(destFile);
            if (!dest) {
                cout << "Error opening destination file.\n";
                break;
            }
            string line;
            while (getline(src, line)) {
                dest << line << "\n";
            }
            src.close();
            dest.close();
            cout << "File copied successfully.\n";
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
