import java.util.Scanner;

public class RecursiveBinarySearch {

    // Recursive Binary Search function
    static int binarySearch(int[] arr, int low, int high, int key) {

        // Base condition
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == key) {
            return mid;
        } 
        else if (arr[mid] > key) {
            return binarySearch(arr, low, mid - 1, key);
        } 
        else {
            return binarySearch(arr, mid + 1, high, key);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = binarySearch(arr, 0, n - 1, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}
