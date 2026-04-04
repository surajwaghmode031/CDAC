// 6: Create CRUD Shop Application Using File
// Write class Product with data member prdid,name,qty,price;
// Menus:
// 1:Add Prd
// 2:Display Prds
// 3:Search Prd
// 4:Update/Modify prd
// 5:delete prd

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class Product {
public:
    int prdid;
    string name;
    int qty;
    double price;

    Product() : prdid(0), name(""), qty(0), price(0.0) {}
    Product(int id, string n, int q, double p) : prdid(id), name(n), qty(q), price(p) {}

    void accept() {
        cout << "Enter Product ID: "; cin >> prdid; cin.ignore();
        cout << "Enter Product Name: "; getline(cin, name);
        cout << "Enter Quantity: "; cin >> qty;
        cout << "Enter Price: "; cin >> price;
        cin.ignore();
    }

    void display() const {
        cout << "\nID: " << prdid << "\nName: " << name << "\nQuantity: " << qty << "\nPrice: " << price << endl;
    }
};

string filename = "products.dat";

void addProduct() {
    Product p;
    p.accept();
    ofstream fout(filename, ios::app | ios::binary);
    fout.write(reinterpret_cast<char*>(&p), sizeof(p));
    fout.close();
    cout << "Product added.\n";
}

void displayProducts() {
    ifstream fin(filename, ios::binary);
    if (!fin) {
        cout << "No products found.\n";
        return;
    }
    Product p;
    bool found = false;
    while (fin.read(reinterpret_cast<char*>(&p), sizeof(p))) {
        p.display();
        found = true;
    }
    fin.close();
    if (!found) cout << "No products to display.\n";
}

void searchProduct() {
    int id;
    cout << "Enter Product ID to search: ";
    cin >> id;
    ifstream fin(filename, ios::binary);
    if (!fin) {
        cout << "No products found.\n";
        return;
    }
    Product p;
    bool found = false;
    while (fin.read(reinterpret_cast<char*>(&p), sizeof(p))) {
        if (p.prdid == id) {
            p.display();
            found = true;
            break;
        }
    }
    fin.close();
    if (!found) cout << "Product not found.\n";
}

void updateProduct() {
    int id;
    cout << "Enter Product ID to update: ";
    cin >> id;
    fstream file(filename, ios::in | ios::out | ios::binary);
    if (!file) {
        cout << "No products found.\n";
        return;
    }
    Product p;
    bool found = false;
    while (file.read(reinterpret_cast<char*>(&p), sizeof(p))) {
        if (p.prdid == id) {
            cout << "Current details:\n";
            p.display();
            cout << "Enter new details:\n";
            p.accept();
            file.seekp(-static_cast<int>(sizeof(p)), ios::cur);
            file.write(reinterpret_cast<char*>(&p), sizeof(p));
            cout << "Product updated.\n";
            found = true;
            break;
        }
    }
    file.close();
    if (!found) cout << "Product not found.\n";
}

void deleteProduct() {
    int id;
    cout << "Enter Product ID to delete: ";
    cin >> id;
    ifstream fin(filename, ios::binary);
    if (!fin) {
        cout << "No products found.\n";
        return;
    }
    ofstream fout("temp.dat", ios::binary);
    Product p;
    bool found = false;
    while (fin.read(reinterpret_cast<char*>(&p), sizeof(p))) {
        if (p.prdid == id) {
            found = true;
            continue;
        }
        fout.write(reinterpret_cast<char*>(&p), sizeof(p));
    }
    fin.close();
    fout.close();
    if (found) {
        remove(filename.c_str());
        rename("temp.dat", filename.c_str());
        cout << "Product deleted.\n";
    } else {
        remove("temp.dat");
        cout << "Product not found.\n";
    }
}

int main() {
    int choice;
    do {
        cout << "\n1. Add Product\n2. Display Products\n3. Search Product\n4. Update Product\n5. Delete Product\n6. Exit\nEnter choice: ";
        cin >> choice;
        cin.ignore();

        switch (choice) {
        case 1: addProduct(); break;
        case 2: displayProducts(); break;
        case 3: searchProduct(); break;
        case 4: updateProduct(); break;
        case 5: deleteProduct(); break;
        case 6: cout << "Exiting...\n"; break;
        default: cout << "Invalid choice.\n";
        }
    } while (choice != 6);

    return 0;
}
