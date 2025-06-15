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
/*// Java program to find minimum element in a 
// sorted rotated array using linear search

import java.util.*;

class GfG {
    static int findMin(int[] arr) {
        int res = arr[0];

        // Traverse over arr[] to find minimum element
        for (int i = 1; i < arr.length; i++) {
            res = Math.min(res, arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}*/
/*// Java program to find minimum element in a 
// sorted and rotated array using binary search

import java.util.*;
class GfG {
    static int findMin(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
          
            // The current subarray is already sorted, 
            // the minimum is at the low index
            if (arr[lo] < arr[hi])        
                return arr[lo];
               
            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
          
            int mid = (lo + hi) / 2;

            // The right half is not sorted. So 
            // the minimum element must be in the
            // right half.
            if (arr[mid] > arr[hi])
                lo = mid + 1;
          
            // The right half is sorted. Note that in 
            // this case, we do not change high to mid - 1
            // but keep it to mid. As the mid element
            // itself can be the smallest
            else
                hi = mid;
        }

        return arr[lo]; 
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}*/
