/*Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.
Examples:
Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
Output: 23
Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1] 
Output: 52
Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52. */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Q12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Array size must be a positive integer.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " integer elements:");

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            Q12 solution = new Q12();
            int result = solution.circularSubarraySum(arr);
            System.out.println("Maximum circular subarray sum: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers only.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        int totalSum = 0;
        int maxKadane = kadane(arr);
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i];
        }

        int maxInverseKadane = kadane(arr);
        int maxCircular = totalSum + maxInverseKadane;

        if (maxCircular == 0) {
            return maxKadane;
        }

        return Math.max(maxKadane, maxCircular);
    }

    // Standard Kadane's Algorithm
    private int kadane(int[] arr) {
        int maxCurrent = arr[0], maxGlobal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }

        return maxGlobal;
    }
}
