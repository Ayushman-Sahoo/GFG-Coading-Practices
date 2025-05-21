/*You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
Note: Positive number starts from 1. The array can have negative integers too.
Examples:
Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.
Input: arr[] = [5, 3, 2, 5, 1]
Output: 4
Explanation: Smallest positive missing number is 4.
Input: arr[] = [-8, 0, -1, -4, -3]
Output: 1
Explanation: Smallest positive missing number is 1.*/
import java.util.Scanner;

public class Q13 {

    // Function to find the smallest positive number missing from the array
    public static int missingNumber(int[] arr) {
        int n = arr.length;

        // Place elements at their correct position
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Find the first index where arr[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // All numbers are in place
        return n + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read array size
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Array size must be positive.");
                return;
            }

            int[] arr = new int[size];

            // Read array elements
            System.out.println("Enter " + size + " integers (can be negative):");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Get and print result
            int result = missingNumber(arr);
            System.out.println("Smallest positive missing number: " + result);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter only integers.");
        } finally {
            scanner.close();
        }
    }
}
