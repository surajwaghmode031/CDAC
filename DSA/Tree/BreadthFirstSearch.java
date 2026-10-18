import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {

    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int val) {
            data = val;
            left = null;
            right = null;
        }

        public Node() {
            data = 0;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BreadthFirstSearch() {
        root = null;
    }

    // add node (BST style)
    public void add(int val) {
        Node newNode = new Node(val);

        if (root == null) {
            root = newNode;
            return;
        }

        Node trav = root;

        while (true) {
            if (val < trav.data) {
                if (trav.left != null)
                    trav = trav.left;
                else {
                    trav.left = newNode;
                    break;
                }
            } else {
                if (trav.right != null)
                    trav = trav.right;
                else {
                    trav.right = newNode;
                    break;
                }
            }
        }
    }

    // BFS search
    public Node bfs(int key) {

        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node trav = q.poll();

            if (key == trav.data)
                return trav;

            if (trav.left != null)
                q.offer(trav.left);

            if (trav.right != null)
                q.offer(trav.right);
        }
        return null;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BreadthFirstSearch tree = new BreadthFirstSearch();

        int choice, val, key;

        do {
            System.out.println("\n---- BFS Menu ----");
            System.out.println("1. Add Node");
            System.out.println("2. Search using BFS");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    tree.add(val);
                    break;

                case 2:
                    System.out.print("Enter key to search: ");
                    key = sc.nextInt();
                    Node result = tree.bfs(key);

                    if (result != null)
                        System.out.println("Key FOUND: " + result.data);
                    else
                        System.out.println("Key NOT FOUND");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
