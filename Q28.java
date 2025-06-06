/*Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 
Examples :
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3. */
import java.util.*;

public class Q28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        // Call the method
        Q28 obj = new Q28();
        int count = obj.countFreq(arr, target);

        // Output result
        System.out.println("Number of occurrences of " + target + ": " + count);
    }

    int countFreq(int[] arr, int target) {
        int first = findFirst(arr, target);
        if (first == -1) return 0;
        int last = findLast(arr, target);
        return last - first + 1;
    }

    private int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
/*// Java program to find the occurrence of given
// target using linear search

class GfG {
    static int countFreq(int[] arr, int target) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
          
            // If the current element is equal to 
            // target, increment the result
            if (arr[i] == target)
                res++;
        }
      
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int target = 2;
        System.out.println(countFreq(arr, target));
    }
}*/
/*// Java program to count occurrence of a given target
// using binary search

class GfG {

    // Function to return Lower Bound
    static int lowerBound(int[] arr, int target) {
        int res = arr.length;
        
        // Search space for binary search
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) {
                res = mid;
                hi = mid - 1;
            } 
          	else {
                lo = mid + 1;
            }
        }
        return res;
    }

    // Function to return Upper Bound
    static int upperBound(int[] arr, int target) {
        int res = arr.length;
        
        // Search space for binary search
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                res = mid;
                hi = mid - 1;
            } 
          	else {
                lo = mid + 1;
            }
        }
        return res;
    }

    static int countFreq(int[] arr, int target) {
      
        // Return the difference between upper
        // bound and lower bound of the target
        return upperBound(arr, target) - 
          						lowerBound(arr, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int target = 2;
        System.out.println(countFreq(arr, target));
    }
}*/