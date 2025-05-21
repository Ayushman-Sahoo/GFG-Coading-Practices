/*Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the largest element.

Examples:

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.
Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist. */
import java.util.Scanner;

public class Q1 {

    public int getSecondLargest(int[] arr) {
        // Initialize variables to track the largest and second largest elements
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            // Update largest and second largest values accordingly
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        // If secondLargest is still Integer.MIN_VALUE, no valid second largest exists
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q1 obj = new Q1();

        try {
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            // Validate array size
            if (n <= 1) {
                System.out.println("Array must have at least 2 elements to find the second largest.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " positive integers:");

            // Validate array elements to ensure they are positive integers
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] <= 0) {
                    System.out.println("Please enter only positive integers.");
                    return;
                }
            }

            // Call the method to find the second largest element
            int result = obj.getSecondLargest(arr);
            System.out.println("Second largest element: " + result);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}