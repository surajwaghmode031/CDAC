package Stack;

import java.util.Scanner;

class StackArray {

    int[] arr;     
    int top;
    int size;

    // constructor
    StackArray(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    // check empty (with message)
    boolean isEmpty() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return true;
        }
        return false;
    }

    // check full (with message)
    boolean isFull() {
        if (top == size - 1) {
            System.out.println("Stack is Full");
            return true;
        }
        return false;
    }

    // push
    void push(int data) {
        if (isFull()) {
            return;
        }
        arr[++top] = data;
        System.out.println(data + " pushed");
    }

    // pop
    void pop() {
        if (isEmpty()) {
            return;
        }
        System.out.println(arr[top--] + " popped");
    }

    // peek
    void peek() {
        if (isEmpty()) {
            return;
        }
        System.out.println("Top element: " + arr[top]);
    }

    // display
    void display() {
        if (isEmpty()) {
            return;
        }

        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        StackArray s = new StackArray(size);

        int choice, data;

        do {
            System.out.println("Enter choice :");
            System.out.println("\n1.Push\n2.Pop\n3.Peek\n4.Display\n0.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    data = sc.nextInt();
                    s.push(data);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.peek();
                    break;

                case 4:
                    s.display();
                    break;

                case 0:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}

