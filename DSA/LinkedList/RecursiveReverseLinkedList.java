class RecursiveReverseLinkedList {

    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void AddAtLast(int val) {
        Node newNode = new Node(val);

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

    // Recursive reverse
    private Node recReverse(Node h) {

        // base case
        if (h == null || h.next == null) {
            return h;
        }

        // reverse remaining list
        Node newHead = recReverse(h.next);

        // fix links
        h.next.next = h;
        h.next = null;

        return newHead;
    }

    // wrapper method
    public void recReverse() {
        head = recReverse(head);
    }

    // display
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        RecursiveReverseLinkedList list = new RecursiveReverseLinkedList();

        list.AddAtLast(10);
        list.AddAtLast(20);
        list.AddAtLast(30);
        list.AddAtLast(40);

        System.out.println("Original List:");
        list.display();

        list.recReverse();

        System.out.println("Reversed List:");
        list.display();
    }
}
