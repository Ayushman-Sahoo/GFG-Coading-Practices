/*Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.
Examples :
Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is found at index 8.
Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: There is no element that has value 6.
Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1.*/
import java.util.*;

public class Q30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.print("Enter elements of the rotated sorted array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input key to search
        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();

        Q30 obj = new Q30();
        int result = obj.search(arr, key);

        System.out.println("Index of key: " + result);
    }

    int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key)
                return mid;

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (key >= arr[low] && key < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } 
            // Right half is sorted
            else {
                if (key > arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1; // Key not found
    }
}
