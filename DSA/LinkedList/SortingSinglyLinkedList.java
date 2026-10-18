import java.util.Scanner;

class SortingSinglyLinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Insert at last
    public void insertAtLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        for (Node i= head; i != null; i= i.next) {
            System.out.print(i.data + " -> ");
        }
        System.out.println("NULL");
    }

    // swap function
    public void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    // Bubble sort (using for loop + swap)
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    swap(i, j);
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        SortingSinglyLinkedList list = new SortingSinglyLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.insertAtLast(sc.nextInt());
        }

        System.out.println("\nBefore sorting:");
        list.display();

        list.sort();

        System.out.println("\nAfter sorting:");
        list.display();

        sc.close();
    }
}
