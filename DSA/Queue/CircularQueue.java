package Queue;

import java.util.Scanner;

public class CircularQueue {

    int[] arr;
    int front, rear, size;

    CircularQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    // empty
    public boolean isEmpty() {
        return front == -1;
    }

    // full
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // enqueue
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("Queue is Full");
        }

        // first insertion
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        arr[rear] = val;
        System.out.println(val + " inserted");
    }

    // dequeue
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        System.out.println(arr[front] + " deleted");

        // only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return arr[front];
    }

    // display
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue elements: ");

        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    // main
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CircularQueue q = new CircularQueue(size);

        while (true) {
            System.out.println("\n1.Push 2.Pop 3.Peek 4.Display 5.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    q.push(sc.nextInt());
                    break;
                case 2:
                    q.pop();
                    break;
                case 3:
                    System.out.println("Front element: " + q.peek());
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
