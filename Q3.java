/*You are given an array of integers arr[]. Your task is to reverse the given array.

Note: Modify the array in place.

Examples:

Input: arr = [1, 4, 3, 2, 6, 5]
Output: [5, 6, 2, 3, 4, 1]
Explanation: The elements of the array are 1 4 3 2 6 5. After reversing the array, the first element goes to the last position, the second element goes to the second last position and so on. Hence, the answer is 5 6 2 3 4 1.
Input: arr = [4, 5, 2]
Output: [2, 5, 4]
Explanation: The elements of the array are 4 5 2. The reversed array will be 2 5 4.
Input: arr = [1]
Output: [1]
Explanation: The array has only single element, hence the reversed array is same as the original. */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Q3 {

    // Method to reverse the array in-place
    public void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Swapping elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q3 sol = new Q3();

        try {
            // Taking size of the array
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();

            if (n < 0) {
                System.out.println("Array size cannot be negative.");
                return;
            }

            int[] arr = new int[n];

            // Taking elements of the array
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Reversing the array
            sol.reverseArray(arr);

            // Printing the reversed array
            System.out.println("Reversed array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter only integers.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}