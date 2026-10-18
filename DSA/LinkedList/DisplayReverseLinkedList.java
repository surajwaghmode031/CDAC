class DisplayReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // add at last
    void addAtLast(int data) {
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
     public void display() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; 
        }
        System.out.println("NULL");
    }

    // ONLY DISPLAY reverse using recursion (no modification)
    void displayReverse(Node node) {
        if (node == null)
            return;

        displayReverse(node.next);   // go to end
        System.out.print(node.data + " -> "); // print while returning
    }

    public static void main(String[] args) {
        DisplayReverseLinkedList list = new DisplayReverseLinkedList();

        list.addAtLast(10);
        list.addAtLast(20);
        list.addAtLast(30);
        list.addAtLast(40);

        System.out.println("Reverse Display:");
        list.displayReverse(list.head);
        System.out.println("NULL");

        System.out.println("nOriginal List :");
        list.display();
    }
}
