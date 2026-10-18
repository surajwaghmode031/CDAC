import java.util.Scanner;

public class BinarySearch {

    // Separate function for Binary Search
    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;   // key found
            } else if (arr[mid] < key) { 
                low = mid + 1;   // search right
            } else {
                high = mid - 1; // search left
            }
        }
        return -1;  // key not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input sorted array elements
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input key
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        // Call binary search function
        int result = binarySearch(arr, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}
