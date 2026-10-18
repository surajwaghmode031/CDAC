import java.util.Scanner;

// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List using Head + Tail
class SinglyLinkedList {
    Node head;
    Node tail;

    // Add at First
    void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {          // empty list
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Add at Last (O(1) using tail)
    void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {          // empty list
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Add at Position (1-based)
    void addAtPosition(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            addFirst(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }

        if (temp == tail) {   // last position
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete First
    void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;

        if (head == null) {   // list became empty
            tail = null;
        }
    }

    // Delete Last
    void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {          // only one node
            head = tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
    }

    // Delete at Position
    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp.next == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }

        if (temp.next == tail) {
            deleteLast();
            return;
        }

        if (temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    // Delete All
    void deleteAll() {
        head = tail = null;
    }

    // Display List
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Main class
public class SingleyLinkedListMainUsingTail {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        int choice, data, pos;

        do {
            System.out.println("\n--- Singly Linked List Menu (Using Tail) ---");
            System.out.println("1. Add at First");
            System.out.println("2. Add at Last");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete at Position");
            System.out.println("7. Delete All");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.addFirst(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.addLast(data);
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    list.addAtPosition(data, pos);
                    break;

                case 4:
                    list.deleteFirst();
                    break;

                case 5:
                    list.deleteLast();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    list.deleteAtPosition(pos);
                    break;

                case 7:
                    list.deleteAll();
                    System.out.println("All nodes deleted");
                    break;

                case 8:
                    list.display();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);

        sc.close();
    }
}
