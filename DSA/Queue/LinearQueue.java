package Queue;

import java.util.Scanner;

public class LinearQueue {

    int[] arr;
    int front, rear, size;

    // constructor
    LinearQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    // check queue full
    public boolean isFull() {
        return rear == size - 1;
    }

    // check queue empty
    public boolean isEmpty() {
        return front == rear;
    }

    // insert (enqueue)
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("Queue is Full");
        }
        rear++;
        arr[rear] = val;
        System.out.println(val + " inserted");
    }

    // delete (dequeue)
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        front++;
        System.out.println(arr[front] + " deleted");
    }

    // peek (front element)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return arr[front + 1];
    }

    // display queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        LinearQueue q = new LinearQueue(size);

        while (true) {
            System.out.println("\n1.Push  2.Pop  3.Peek  4.Display  5.Exit");
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
                    System.out.println("Exit");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
