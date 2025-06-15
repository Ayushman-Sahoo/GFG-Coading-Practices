/*Given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist). If there are multiple peak elements, return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".
Note: Consider the element before the first element and the element after the last element to be negative infinity.
Examples :
Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].
Input: arr = [10, 20, 15, 2, 23, 90, 80]
Output: true
Explanation: arr[1] = 20 and arr[5] = 90 are peak elements because arr[0] < arr[1] > arr[2] and arr[4] < arr[5] > arr[6]. 
Input: arr = [1, 2, 3]
Output: true
Explanation: arr[2] is a peak element because arr[1] < arr[2] and arr[2] is the last element, so it has negative infinity to its right.*/
import java.util.Scanner;

public class Q31 {

    // Function to find a peak element
    public int peakElement(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // low == high is the peak index
    }

    // Helper function to verify the returned index is a valid peak
    public static boolean isPeak(int[] arr, int index) {
        int left = (index - 1 >= 0) ? arr[index - 1] : Integer.MIN_VALUE;
        int right = (index + 1 < arr.length) ? arr[index + 1] : Integer.MIN_VALUE;
        return arr[index] > left && arr[index] > right;
    }

    // Main method to take input and run the logic
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q31 solution = new Q31();

        System.out.print("Enter number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements (no two adjacent elements should be same):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int peakIndex = solution.peakElement(arr);
        boolean result = isPeak(arr, peakIndex);

        System.out.println(result);  // true if valid peak
    }
}
/*// Java program to find a peak element in the given array
// Using Linear Search

import java.util.*;
class GfG {
    static int peakElement(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean left = true;
            boolean right = true;

            // Check for element to the left
            if (i > 0 && arr[i] <= arr[i - 1])
                left = false;

            // Check for element to the right
            if (i < n - 1 && arr[i] <= arr[i + 1])
                right = false;

            // If arr[i] is greater than its left as well as
            // its right element, return its index
            if (left && right) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peakElement(arr));
    }
}*/
/*// Java program to find a peak element in the given array
// Using Binary Search

class GfG {

    static int peakElement(int[] arr) {
        int n = arr.length;

        // If there is only one element, then it's a peak
        if (n == 1)
            return 0;

        // Check if the first element is a peak
        if (arr[0] > arr[1])
            return 0;

        // Check if the last element is a peak
        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        // Search Space for binary Search
        int lo = 1, hi = n - 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If the element at mid is a  
            // peak element return mid
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;

            // If next neighbor is greater, then peak
            // element will exist in the right subarray
            if (arr[mid] < arr[mid + 1])
                lo = mid + 1;

            // Otherwise, it will exist in left subarray
            else
                hi = mid - 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peakElement(arr));
    }
}*/