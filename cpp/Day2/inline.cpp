// Assignment: Inline Functions in C++
// Write a program using inline functions to calculate:
// Area of a square (side × side)
// Area of a rectangle (length × breadth)
// Area of a circle (π × r × r, use π = 3.14159)

#include <iostream>
using namespace std;

const float PI = 3.14159;

inline float areaSquare(float side) {
    return side * side;
}

inline float areaRectangle(float length, float breadth) {
    return length * breadth;
}

inline float areaCircle(float radius) {
    return PI * radius * radius;
}

int main() {
    float side, length, breadth, radius;

    cout << "Enter side of square: ";
    cin >> side;
    cout << "Area of square: " << areaSquare(side) << endl;

    cout << "\nEnter length and breadth of rectangle: ";
    cin >> length >> breadth;
    cout << "Area of rectangle: " << areaRectangle(length, breadth) << endl;

    cout << "\nEnter radius of circle: ";
    cin >> radius;
    cout << "Area of circle: " << areaCircle(radius) << endl;

    return 0;
}

