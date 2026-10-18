package Queue;

import java.util.Scanner;

public class PriorityQueue {

    public static void main(String[] args) {

        java.util.PriorityQueue<Integer> pq =
                new java.util.PriorityQueue<>(); // MIN priority queue

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                "\n1.Push 2.Pop 3.Peek 4.Display 5.PollAll 6.Exit"
            );
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: // push
                    System.out.print("Enter value: ");
                    pq.add(sc.nextInt());
                    System.out.println("Inserted");
                    break;

                case 2: // pop
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is Empty");
                    } else {
                        System.out.println(pq.poll() + " removed");
                    }
                    break;

                case 3: // peek
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is Empty");
                    } else {
                        System.out.println("Highest Priority: " + pq.peek());
                    }
                    break;

                case 4: // display
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is Empty");
                    } else {
                        System.out.println(pq);
                    }
                    break;

                case 5: // poll all
                    if (pq.isEmpty()) {
                        System.out.println("Priority Queue is Empty");
                    } else {
                        System.out.print("Polling all elements: ");
                        while (!pq.isEmpty()) {
                            System.out.print(pq.poll() + " ");
                        }
                        System.out.println();
                    }
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
