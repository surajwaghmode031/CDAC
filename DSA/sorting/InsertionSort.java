import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];  // arr[1]  index    arr[2]
            int j = i - 1;    //  arr[0]  index    arr[1]

            // Shift elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key; // key inserting 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}
