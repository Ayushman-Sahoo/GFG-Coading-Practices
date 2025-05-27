/*Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

You need to solve this problem without utilizing the built-in sort function.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.

Follow up: Could you come up with a one-pass algorithm using only constant extra space? */
import java.util.Scanner;

public class Q21 {
    
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid], then increment both
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high], decrement high
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q21 obj = new Q21();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements (only 0s, 1s, and 2s):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 0 || arr[i] > 2) {
                System.out.println("Invalid input! Only 0, 1, or 2 are allowed.");
                return;
            }
        }

        obj.sort012(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
