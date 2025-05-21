/*Given an array arr[] denoting heights of N towers and a positive integer K.
For each tower, you must perform exactly one of the following operations exactly once.
Increase the height of the tower by K
Decrease the height of the tower by K
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.

Given a array arr[] and positive integer k denoting heights of towers, you have to modify the height of each tower either by increasing or decreasing them by k only once.Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.

Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.
Examples :
Input: k = 2, arr[] = {1, 5, 8, 10}
Output: 5
Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.
Input: k = 3, arr[] = {3, 9, 12, 16, 20}
Output: 11
Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11. */
import java.util.*;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Prompt for k
            System.out.print("Enter the value of k: ");
            int k = sc.nextInt();
            if (k < 0) {
                throw new IllegalArgumentException("k must be a positive integer.");
            }

            // Prompt for number of towers
            System.out.print("Enter number of towers: ");
            int n = sc.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Number of towers must be positive.");
            }

            // Prompt for tower heights
            int[] arr = new int[n];
            System.out.print("Enter the heights of the towers: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] < 0) {
                throw new IllegalArgumentException("Tower heights cannot be negative.");
                }
            }

            // Compute and display result
            Solution solution = new Solution();
            int result = solution.getMinDiff(arr, k);
            System.out.println("Minimum possible difference: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers only.");
        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        Arrays.sort(arr);

        int diff = arr[n - 1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue;

            int min = Math.min(smallest, arr[i] - k);
            int max = Math.max(largest, arr[i - 1] + k);

            diff = Math.min(diff, max - min);
        }

        return diff;
    }
}
