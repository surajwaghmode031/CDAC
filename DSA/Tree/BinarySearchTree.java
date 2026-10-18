import java.util.Scanner;

public class BinarySearchTree {

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

    public BinarySearchTree() {
        root = null;
    }

    // add node
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

    // PREORDER (PLR)
    private void preorderTraversal(Node trav) {
        if (trav == null)
            return;
        System.out.print(trav.data + " ");
        preorderTraversal(trav.left);
        preorderTraversal(trav.right);
    }

    public void preorderTraversal() {
        preorderTraversal(root);
        System.out.println();
    }

    // POSTORDER (LRP)
    private void postorderTraversal(Node trav) {
        if (trav == null)
            return;
        postorderTraversal(trav.left);
        postorderTraversal(trav.right);
        System.out.print(trav.data + " ");
    }

    public void postorderTraversal() {
        postorderTraversal(root);
        System.out.println();
    }

    // INORDER (LPR)
    private void inorderTraversal(Node trav) {
        if (trav == null)
            return;
        inorderTraversal(trav.left);
        System.out.print(trav.data + " ");
        inorderTraversal(trav.right);
    }

    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    // DELETE ALL
    private void deleteAll(Node trav) {
        if (trav == null)
            return;
        deleteAll(trav.left);
        deleteAll(trav.right);
        trav.left = null;
        trav.right = null;
    }

    public void deleteAll() {
        deleteAll(root);
        root = null;
        System.out.println("Tree deleted successfully");
    }

    // HEIGHT
    private int height(Node trav) {
        if (trav == null)
            return -1;
        int hl = height(trav.left);
        int hr = height(trav.right);
        return Math.max(hl, hr) + 1;
    }

    public int height() {
        return height(root);
    }

    // ===== BST SEARCH USING RECURSION =====
    private Node searchRec(Node trav, int key) {
        if (trav == null)
            return null;

        if (trav.data == key)
            return trav;

        if (key < trav.data)
            return searchRec(trav.left, key);
        else
            return searchRec(trav.right, key);
    }

    public Node searchRec(int key) {
        return searchRec(root, key);
    }

    // ===== BST SEARCH WITHOUT RECURSION =====
    public Node searchIter(int key) {
        Node trav = root;

        while (trav != null) {
            if (trav.data == key)
                return trav;

            if (key < trav.data)
                trav = trav.left;
            else
                trav = trav.right;
        }
        return null;
    }

    // ===== BST SEARCH NODE WITH PARENT =====
    public Node[] searchWithParent(int key) {

        Node parent = null;
        Node trav = root;

        while (trav != null) {

            if (trav.data == key) {
                return new Node[] { trav, parent };
            }

            parent = trav;

            if (key < trav.data)
                trav = trav.left;
            else
                trav = trav.right;
        }

        return new Node[] { null, null };
    }

    // ================= MENU DRIVEN =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice, val, key;

        do {
            System.out.println("\n----- Binary Search Tree Menu -----");
            System.out.println("1. Add Node");
            System.out.println("2. Preorder Traversal");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. Height of Tree");
            System.out.println("6. Search (Recursion)");
            System.out.println("7. Search (Without Recursion)");
            System.out.println("8. Search Node with Parent");
            System.out.println("9. Delete All Nodes");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    bst.add(val);
                    break;

                case 2:
                    System.out.print("Preorder: ");
                    bst.preorderTraversal();
                    break;

                case 3:
                    System.out.print("Inorder: ");
                    bst.inorderTraversal();
                    break;

                case 4:
                    System.out.print("Postorder: ");
                    bst.postorderTraversal();
                    break;

                case 5:
                    System.out.println("Height = " + bst.height());
                    break;

                case 6:
                    System.out.print("Enter key: ");
                    key = sc.nextInt();
                    System.out.println(
                        bst.searchRec(key) != null ? "Key FOUND" : "Key NOT FOUND"
                    );
                    break;

                case 7:
                    System.out.print("Enter key: ");
                    key = sc.nextInt();
                    System.out.println(
                        bst.searchIter(key) != null ? "Key FOUND" : "Key NOT FOUND"
                    );
                    break;

                case 8:
                    System.out.print("Enter key: ");
                    key = sc.nextInt();
                    Node[] res = bst.searchWithParent(key);

                    if (res[0] != null) {
                        System.out.println("Node found: " + res[0].data);
                        if (res[1] != null)
                            System.out.println("Parent node: " + res[1].data);
                        else
                            System.out.println("Parent node: NULL (root)");
                    } else {
                        System.out.println("Key NOT FOUND");
                    }
                    break;

                case 9:
                    bst.deleteAll();
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
