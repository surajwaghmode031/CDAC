

#include <iostream>
using namespace std;

int main() {
    int choice, quantity;
    double total = 0;

    cout<<"-----------welcome------------"<<endl;

    do {
        cout << "\tMenu:\n";
        cout << "1. Margherita      - 350 RS"<<endl;
        cout << "2. Pepperoni       - 399 RS"<<endl;
        cout << "3. BBQ Chicken     - 499 RS"<<endl;
        cout << "4. Veggie          - 250 RS"<<endl;
        cout << "5. Cheese Burst    - 299 RS"<<endl;
        cout << "0. Show bill "<<endl;

        cout << "\nEnter your choice: ";
        cin >> choice;
         if (choice == 0) 
            break;
         cout << "\nEnter quantity : ";
        cin >> quantity;

         

        switch(choice)
        {
            case 1:
                 total+=350*quantity;
                 break;
            case 2:
                total+= 399*quantity;
                break;
            case 3:
                total+= 499*quantity;
                break;
            case 4:
                total+= 250*quantity;
                break;
            case 5:
                total+= 299*quantity;
                break;
            default:
                cout << "Invalid choice."<<endl;
        }
    }while(choice!=0);
    cout<<"\t-------bill---------"<<endl;
    cout << "\tTotal Amount: " << total <<"RS"<< endl;
    cout << "\tThank you !"<<endl;
    cout << "\tHave a nice day...!";
}