import java.util.Scanner;

class DoublyLinearLinkedList {

    // Node class
    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    Node head;

    // add at first
    void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // add at last
    void addLast(int data) {
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
        newNode.prev = temp;
    }

    // add at position
    void addAtPosition(int data, int pos) {
        if (pos < 1) {
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

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // delete first
    void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // delete last
    void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }

    // delete at position
    void deleteAtPosition(int pos) {
        if (head == null || pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // delete all
    void deleteAll() {
        head = null;
    }

    // display forward
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class DoublyLinearLinkedListMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoublyLinearLinkedList list = new DoublyLinearLinkedList();

        int choice, data, pos;

        do {
            System.out.println("\n--- Doubly Linear Linked List Menu ---");
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
                    data = sc.nextInt();
                    list.addFirst(data);
                    break;

                case 2:
                    data = sc.nextInt();
                    list.addLast(data);
                    break;

                case 3:
                    data = sc.nextInt();
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
