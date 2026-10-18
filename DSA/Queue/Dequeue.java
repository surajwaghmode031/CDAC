package Queue;

import java.util.Scanner;

public class Dequeue {

    int[] arr;
    int head, tail, size;

    Dequeue(int size) {
        this.size = size;
        arr = new int[size];
        head = -1;
        tail = -1;
    }

    // empty
    boolean isEmpty() {
        return head == -1;
    }

    // full
    boolean isFull() {
        return (tail + 1) % size == head;
    }

    // push front
    void pushFront(int val) {
        if (isFull()) {
            System.out.println("Dequeue is Full");
            return;
        }

        if (isEmpty()) {
            head = tail = 0;
        } else {
            head = (head - 1 + size) % size;
        }
        arr[head] = val;
        System.out.println(val + " pushed at front");
    }

    // push back
    void pushBack(int val) {
        if (isFull()) {
            System.out.println("Dequeue is Full");
            return;
        }

        if (isEmpty()) {
            head = tail = 0;
        } else {
            tail = (tail + 1) % size;
        }
        arr[tail] = val;
        System.out.println(val + " pushed at back");
    }

    // pop front
    void popFront() {
        if (isEmpty()) {
            System.out.println("Dequeue is Empty");
            return;
        }

        System.out.println(arr[head] + " popped from front");

        if (head == tail) {
            head = tail = -1;
        } else {
            head = (head + 1) % size;
        }
    }

    // pop back
    void popBack() {
        if (isEmpty()) {
            System.out.println("Dequeue is Empty");
            return;
        }

        System.out.println(arr[tail] + " popped from back");

        if (head == tail) {
            head = tail = -1;
        } else {
            tail = (tail - 1 + size) % size;
        }
    }

    // display
    void display() {
        if (isEmpty()) {
            System.out.println("Dequeue is Empty");
            return;
        }

        System.out.print("Dequeue elements: ");
        int i = head;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == tail)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        Dequeue dq = new Dequeue(size);

        while (true) {
            System.out.println("\n1.PushFront 2.PushBack 3.PopFront 4.PopBack 5.Display 6.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    dq.pushFront(sc.nextInt());
                    break;
                case 2:
                    dq.pushBack(sc.nextInt());
                    break;
                case 3:
                    dq.popFront();
                    break;
                case 4:
                    dq.popBack();
                    break;
                case 5:
                    dq.display();
                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
