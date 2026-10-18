import java.util.Scanner;

class CircularSinglyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // add at first
    void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        head = newNode;
        temp.next = head;
    }

    // add at last
    void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // add at position
    void addAtPosition(int data, int pos) {
        Node newNode = new Node(data);

        if (head == null) {
            if (pos == 1) {
                head = newNode;
                newNode.next = head;
            } else {
                System.out.println("Invalid position");
            }
            return;
        }

        if (pos == 1) {
            addFirst(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp.next == head) {
                break;
            }
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // delete first
    void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        head = head.next;
        temp.next = head;
    }

    // delete last
    void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }

        temp.next = head;
    }

    // delete at position
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
            if (temp.next == head) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    // delete all
    void deleteAll() {
        head = null;
    }

    // display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }
}

public class SinglyCircularLinkedListMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

        int choice, data, pos;

        do {
            System.out.println("\n--- Singly Circular Linked List Menu ---");
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
