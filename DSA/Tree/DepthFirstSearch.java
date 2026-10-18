import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearch {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    private Node root;

    public DepthFirstSearch() {
        root = null;
    }

    // Add node (BST insertion)
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

    // ================= DFS SEARCH =================
    private Node dfs( int key) {
         if (root == null)
            return null;

        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node trav = s.pop();

            if (key == trav.data)
                return trav;

            if (trav.right != null)
                s.push(trav.right);

              if (trav.left != null)
                s.push(trav.left);
        }
        return null;
    }
    
    

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepthFirstSearch tree = new DepthFirstSearch();

        int choice, val, key;

        do {
            System.out.println("\n---- DFS Menu ----");
            System.out.println("1. Add Node");
            System.out.println("2. Search using DFS");
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
                    Node result = tree.dfs(key);

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

