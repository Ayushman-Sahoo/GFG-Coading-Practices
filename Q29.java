/*A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 
Examples:
Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element in the array.
Input: arr[] = [3, 1, 2]
Output: 1
Explanation: Here 1 is the minimum element.
Input: arr[] = [4, 2, 3]
Output: 2
Explanation: Here 2 is the minimum element.*/
import java.util.Scanner;
public class Q29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read array size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        // Read array elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " distinct elements (sorted then rotated):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Find and print the minimum element
        Q29 obj = new Q29();
        int minElement = obj.findMin(arr);
        System.out.println("Minimum element is: " + minElement);

        sc.close();
    }
    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }
        return arr[left];
    }
}