public class ReverseSingularLinerLinkedList {

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public ReverseSingularLinerLinkedList() {
        this.head = null;
    }

    // add at last
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

    // display
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

    // reverse singly linked list
    public void reverseList() {
        // consider current list is old and new list is empty
        Node oldhead = head;
        head = null;

        while (oldhead != null) {
            // delete first from old list
            Node temp = oldhead;
            oldhead = oldhead.next;

            // add first into new list
            temp.next = head;
            head = temp;
        }
    }

    public static void main(String[] args) {
        ReverseSingularLinerLinkedList list =
                new ReverseSingularLinerLinkedList();

        list.AddAtLast(10);
        list.AddAtLast(20);
        list.AddAtLast(30);
        list.AddAtLast(40);

        System.out.println("list before reverse:");
        list.display();

        list.reverseList();

        System.out.println("list after reverse:");
        list.display();
    }
}
