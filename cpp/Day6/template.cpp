// 🔹 Basic Template Assignments

#include <iostream>
#include <string>
using namespace std;

// 1: Function Template – Swap
template <typename T>
void swapValues(T &a, T &b) {
    T temp = a;
    a = b;
    b = temp;
}

// 2: Function Template – Maximum
template <typename T>
T findMax(T a, T b) {
    return (a > b) ? a : b;
}

// 3: Class Template – Box
template <typename T>
class Box {
    T value;
public:
    void setValue(T val) {
        value = val;
    }
    T getValue() {
        return value;
    }
};

// 4: Class Template – Calculator
template <typename T>
class Calculator {
public:
    T add(T a, T b) {
        return a + b;
    }
    T subtract(T a, T b) {
        return a - b;
    }
    T multiply(T a, T b) {
        return a * b;
    }
    T divide(T a, T b) {
        return b != 0 ? a / b : 0;
    }
};

// 5: Function Template – Array Sum
template <typename T>
T sumArray(T arr[], int size) {
    T sum = 0;
    for (int i = 0; i < size; i++) {
        sum += arr[i];
    }
    return sum;
}

// 6: Class Template – Stack
template <typename T>
class Stack {
    T arr[100];
    int top;
public:
    Stack() { top = -1; }
    void push(T val) {
        if (top < 99)
            arr[++top] = val;
    }
    void pop() {
        if (top >= 0)
            top--;
    }
    T peek() {
        return top >= 0 ? arr[top] : T();
    }
    bool isEmpty() {
        return top == -1;
    }
};

// 7: Class Template – Queue
template <typename T>
class Queue {
    T arr[100];
    int frontIdx, rearIdx;
public:
    Queue() {
        frontIdx = 0;
        rearIdx = -1;
    }
    void enqueue(T val) {
        if (rearIdx < 99)
            arr[++rearIdx] = val;
    }
    void dequeue() {
        if (!isEmpty())
            frontIdx++;
    }
    T front() {
        return !isEmpty() ? arr[frontIdx] : T();
    }
    bool isEmpty() {
        return frontIdx > rearIdx;
    }
};

int main() {

    // 1: Swap Function Template Test
    int a = 5, b = 10;
    swapValues(a, b);
    cout << "Swapped int: " << a << " " << b << endl;

    double x = 2.5, y = 4.7;
    swapValues(x, y);
    cout << "Swapped double: " << x << " " << y << endl;

    string s1 = "Hello", s2 = "World";
    swapValues(s1, s2);
    cout << "Swapped string: " << s1 << " " << s2 << endl;

    // 2: Maximum Function Template Test
    cout << "Max of 3 and 7 (int): " << findMax(3, 7) << endl;
    cout << "Max of 3.5 and 7.2 (float): " << findMax(3.5f, 7.2f) << endl;
    cout << "Max of 'a' and 'z' (char): " << findMax('a', 'z') << endl;

    // 3: Box Class Template Test
    Box<int> intBox;
    intBox.setValue(42);
    cout << "Boxed int: " << intBox.getValue() << endl;

    Box<string> strBox;
    strBox.setValue("Template");
    cout << "Boxed string: " << strBox.getValue() << endl;

    // 4: Calculator Class Template Test
    Calculator<int> intCalc;
    cout << "Add (int): " << intCalc.add(10, 5) << endl;
    cout << "Divide (int): " << intCalc.divide(10, 2) << endl;

    Calculator<double> dblCalc;
    cout << "Multiply (double): " << dblCalc.multiply(2.5, 4.0) << endl;

    // 5: Array Sum Function Template Test
    int arr1[] = {1, 2, 3, 4, 5};
    cout << "Sum of int array: " << sumArray(arr1, 5) << endl;

    double arr2[] = {1.1, 2.2, 3.3};
    cout << "Sum of double array: " << sumArray(arr2, 3) << endl;

    // 6: Stack Class Template Test
    Stack<int> intStack;
    intStack.push(10);
    intStack.push(20);
    cout << "Stack peek (int): " << intStack.peek() << endl;
    intStack.pop();
    cout << "After pop, peek: " << intStack.peek() << endl;

    Stack<string> strStack;
    strStack.push("C++");
    strStack.push("Templates");
    cout << "Stack peek (string): " << strStack.peek() << endl;

    // 7: Queue Class Template Test
    Queue<int> intQueue;
    intQueue.enqueue(100);
    intQueue.enqueue(200);
    cout << "Queue front (int): " << intQueue.front() << endl;
    intQueue.dequeue();
    cout << "After dequeue, front: " << intQueue.front() << endl;

    Queue<string> strQueue;
    strQueue.enqueue("One");
    strQueue.enqueue("Two");
    cout << "Queue front (string): " << strQueue.front() << endl;

    return 0;
}
