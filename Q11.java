/*Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].
Note: It is guaranteed that the output fits in a 32-bit integer.
Examples
Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180.
Input: arr[] = [-1, -3, -10, 0, 6]
Output: 30
Explanation: The subarray with maximum product is {-3, -10} with product = (-3) * (-10) = 30.
Input: arr[] = [2, 3, 4] 
Output: 24 
Explanation: For an array with all positive elements, the result is product of all elements.  */
import java.util.Scanner;

public class Q11 {

    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];

            int tempMax = maxEndingHere;

            maxEndingHere = Math.max(num, Math.max(maxEndingHere * num, minEndingHere * num));
            minEndingHere = Math.min(num, Math.min(tempMax * num, minEndingHere * num));

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter number of elements in the array:");
            int n = Integer.parseInt(scanner.nextLine().trim());

            if (n <= 0) {
                System.out.println("Array size must be positive.");
                return;
            }

            System.out.println("Enter the array elements separated by spaces:");
            String[] parts = scanner.nextLine().trim().split("\\s+");

            if (parts.length != n) {
                System.out.println("Mismatch between declared size and number of elements entered.");
                return;
            }

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            Q11 solution = new Q11();
            int result = solution.maxProduct(arr);
            System.out.println("Maximum product of subarray: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter only integers.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}