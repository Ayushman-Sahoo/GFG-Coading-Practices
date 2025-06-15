/*Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.
Examples :
Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is found at index 8.
Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: There is no element that has value 6.
Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1.*/
import java.util.*;

public class Q30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.print("Enter elements of the rotated sorted array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input key to search
        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();

        Q30 obj = new Q30();
        int result = obj.search(arr, key);

        System.out.println("Index of key: " + result);
    }

    int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key)
                return mid;

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (key >= arr[low] && key < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } 
            // Right half is sorted
            else {
                if (key > arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1; // Key not found
    }
}
/*// Java program to search an element in sorted and rotated 
// array using binary search twice

import java.util.*;
class GfG {
  
    // An iterative binary search function
    static int binarySearch(int[] arr, int lo, int hi, int x) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    // Function to return pivot (index of the smallest element)
    static int findPivot(int[] arr, int lo, int hi) {
        while (lo < hi) {
          
            // The current subarray is already sorted,
            // the minimum is at the low index
            if (arr[lo] <= arr[hi])
                return lo;

            int mid = (lo + hi) / 2;

            // The right half is not sorted. So
            // the minimum element must be in the
            // right half
            if (arr[mid] > arr[hi])
                lo = mid + 1;

            // The right half is sorted. Note that in
            // this case, we do not change high to mid - 1
            // but keep it to mid. The mid element
            // itself can be the smallest
            else
                hi = mid;
        }

        return lo;
    }

    // Searches an element key in a pivoted
    // sorted array arr of size n
    static int search(int[] arr, int key) {
        int n = arr.length;
        int pivot = findPivot(arr, 0, n - 1);

        // If we found a pivot, then first compare with pivot
        // and then search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
      
        // If the minimum element is present at index
        // 0, then the whole array is sorted
        if (pivot == 0)
            return binarySearch(arr, 0, n - 1, key);

        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        System.out.println(search(arr, key));
    }
}*/
/*// Java program to search an element in sorted and rotated 
// array using binary search

import java.util.*;
class GfG {
  
    static int search(int[] arr, int key) {
      
        // Initialize two pointers, lo and hi, at the start
        // and end of the array
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If key found, return the index
            if (arr[mid] == key)
                return mid;

            // If Left half is sorted
            if (arr[mid] >= arr[lo]) {
              
                // If the key lies within this sorted half,
                // move the hi pointer to mid - 1
                if (key >= arr[lo] && key < arr[mid])
                    hi = mid - 1;
              
                // Otherwise, move the lo pointer to mid + 1
                else
                    lo = mid + 1;
            }
          
            // If Right half is sorted
            else {
              
                // If the key lies within this sorted half,
                // move the lo pointer to mid + 1
                if (key > arr[mid] && key <= arr[hi])
                    lo = mid + 1;
              
                // Otherwise, move the hi pointer to mid - 1
                else
                    hi = mid - 1;
            }
        }
      
        // Key not found
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key1 = 3;
        System.out.println(search(arr1, key1));
    }
}*/
