/*Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.
Note: Consider the array as circular.
Examples :
Input: arr[] = [1, 2, 3, 4, 5], d = 2
Output: [3, 4, 5, 1, 2]
Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.
Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.
Input: arr[] = [7, 3, 9, 1], d = 9
Output: [3, 9, 1, 7]
Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q4 {
    // Efficient in-place rotation using reversal algorithm
    static void rotateLeft(int[] arr, int d) {
        int n = arr.length;
        d %= n;  // Handle d > n

        if (d == 0 || n <= 1) return;  // No need to rotate

        reverse(arr, 0, d - 1);       // Reverse first part
        reverse(arr, d, n - 1);       // Reverse second part
        reverse(arr, 0, n - 1);       // Reverse whole array
    }

    // Reverses elements from start to end
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter array size: ");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Array size must be a positive integer.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter number of left rotations: ");
            int d = sc.nextInt();

            if (d < 0) {
                System.out.println("Number of rotations must be non-negative.");
                return;
            }

            rotateLeft(arr, d);

            System.out.println("Array after rotation:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter only integers.");
        } finally {
            sc.close();
        }
    }
}
