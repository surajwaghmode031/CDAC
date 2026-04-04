// Create a class ComplexNumber with data members real, imaginary. Create Default and Parameterized constructors. Write getters and setters for all the data members. Also add the display function. Create the object of this class in main method and invoke all the methods in that class.
#include <iostream>
using namespace std;

class ComplexNumber {
private:
    double real;
    double imaginary;

public:
    // Default constructor
    ComplexNumber() {
        real = 0;
        imaginary = 0;
    }

    // Parameterized constructor
    ComplexNumber(double r, double i) {
        real = r;
        imaginary = i;
    }

    // Setter for real part
    void setReal(double r) {
        real = r;
    }

    // Setter for imaginary part
    void setImaginary(double i) {
        imaginary = i;
    }

    // Getter for real part
    double getReal() {
        return real;
    }

    // Getter for imaginary part
    double getImaginary() {
        return imaginary;
    }

    // Display function
    void display() {
        cout << "Complex Number: " << real;
        if (imaginary >= 0)
            cout << " + " << imaginary << "i" << endl;
        else
            cout << " - " << -imaginary << "i" << endl;
    }
};

int main() {
    // Creating object using default constructor
    ComplexNumber c1;
    cout << "Default Constructor Output:" << endl;
    c1.display();

    // Using setters
    c1.setReal(3.5);
    c1.setImaginary(-2.5);
    cout << "\nAfter using setters:" << endl;
    c1.display();

    // Getting individual parts
    cout << "\nUsing getters:" << endl;
    cout << "Real part: " << c1.getReal() << endl;
    cout << "Imaginary part: " << c1.getImaginary() << endl;

    // Creating object using parameterized constructor
    ComplexNumber c2(4.2, 5.8);
    cout << "\nParameterized Constructor Output:" << endl;
    c2.display();

    return 0;
}