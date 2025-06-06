/*Given an integer array arr[]. You need to find the maximum sum of a subarray.
Examples:
Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray {-2} has the largest sum -2.
Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.*/
import java.util.Scanner;

public class Q10 {

    // Function to find the maximum sum of a subarray
    int maxSubarraySum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int currMax = 0;

        for (int i = 0; i < arr.length; i++) {
            currMax += arr[i];
            if (currMax > maxSoFar) {
                maxSoFar = currMax;
            }
            if (currMax < 0) {
                currMax = 0;
            }
        }

        return maxSoFar;
    }

    // Main method with user input and error handling
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                throw new IllegalArgumentException("Array size must be greater than 0.");
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            Q10 solution = new Q10();
            int result = solution.maxSubarraySum(arr);
            System.out.println("Maximum subarray sum is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
