/*Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.
Examples:
Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output:
2 2 3 4
7 10
Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output:
1 2 3 5 8 9
10 13 15 20
Explanation: After merging two sorted arrays we get 1 2 3 5 8 9 10 13 15 20.
Input: a[] = [0, 1], b[] = [2, 3]
Output:
0 1
2 3
Explanation: After merging two sorted arrays we get 0 1 2 3.*/
import java.util.Scanner;

public class Q27 {
    // Function to calculate the next gap
    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    // Function to merge two arrays in-place without using extra space
    public static void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < n + m) {
                // Case 1: both i and j in a[]
                if (i < n && j < n) {
                    if (a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
                // Case 2: i in a[], j in b[]
                else if (i < n && j >= n) {
                    if (a[i] > b[j - n]) {
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    }
                }
                // Case 3: both i and j in b[]
                else if (i >= n && j >= n) {
                    if (b[i - n] > b[j - n]) {
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                }
                i++;
                j++;
            }

            gap = nextGap(gap);
        }
    }

    // Main method to take input and run the merging
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for array a[]
        System.out.print("Enter size of array a[]: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter " + n + " sorted elements for array a[]: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Input for array b[]
        System.out.print("Enter size of array b[]: ");
        int m = sc.nextInt();
        int[] b = new int[m];
        System.out.print("Enter " + m + " sorted elements for array b[]: ");
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        // Merge the arrays
        mergeArrays(a, b);

        // Print modified array a[]
        System.out.println("Modified array a[]:");
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();

        // Print modified array b[]
        System.out.println("Modified array b[]:");
        for (int i : b)
            System.out.print(i + " ");
        System.out.println();
    }
}
/*// Merge two sorted arrays a[] and b[] with O(1) extra space.
// using Gap method of Shell sort
import java.util.Arrays;

class GfG {
    static void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = (n + m + 1) / 2;

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < n + m) {
              
                // If both pointers are in the first array a[]
                if (j < n && a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                } 
              
                // If first pointer is in a[] and 
                // the second pointer is in b[]
                else if (i < n && j >= n && a[i] > b[j - n]) {
                    int temp = a[i];
                    a[i] = b[j - n];
                    b[j - n] = temp;
                } 
              
                // Both pointers are in the second array b
                else if (i >= n && b[i - n] > b[j - n]) {
                    int temp = b[i - n];
                    b[i - n] = b[j - n];
                    b[j - n] = temp;
                }
                i++;
                j++;
            }

            // After operating for gap of 1 break the loop
            if (gap == 1) break;

            // Calculate the next gap
            gap = (gap + 1) / 2;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArrays(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
}*/
/*// Java program to merge two sorted arrays a[] and b[] 
// without extra space Using swap and sort
import java.util.Arrays;

class GfG {
    static void mergeArrays(int[] a, int[] b) {
        int i = a.length - 1, j = 0;

        // Swap smaller elements from b[] with larger elements from a[]
        while (i >= 0 && j < b.length) {
            if (a[i] < b[j])
                i--;
            else {
                int temp = b[j];
                b[j] = a[i];
                a[i] = temp;
                i--;
                j++;
            }
        }

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArrays(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
}*/
/*// Java program to merge two sorted arrays a[] and b[]
// without extra space using n-th smallest number

import java.util.Arrays;

class GfG {

    // Find m-th smallest element
    // Do a binary search in a[] to find the right index idx
    // in a[] such that all combined elements in a[idx..m-1]
    // and b[m-idx...n-1] are greater than or equal to all
    // the remaining elements (a[0..idx-1] and b[m-idx-1..n-1])
    // in both the arrays.
    static int kthSmallest(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;
        int lo = 0, hi = n, idx = 0;
        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = k - mid1;

            // We don't have mid2 elements in b[], so pick more
            // elements from a[]
            if (mid2 > m) {
                lo = mid1 + 1;
                continue;
            }

            // Find elements to the left and right of partition in a[]
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);

            // Find elements to the left and right of partition in b[]
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE : b[mid2]);

            // If it is a valid partition
            if (l1 <= r2 && l2 <= r1) {
                idx = mid1;
                break;
            }

            // Check if we need to take lesser elements from a[]
            if (l1 > r2)
                hi = mid1 - 1;

            // Check if we need to take more elements from a[]
            else
                lo = mid1 + 1;
        }
        return idx;
    }

    static void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int idx = kthSmallest(a, b, n);

        // Move all smaller elements in a[]
        for (int i = idx; i < n; i++) {
            int temp = a[i];
            a[i] = b[i - idx];
            b[i - idx] = temp;
        }

        // Sort both a[] and b[]
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArrays(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
}*/
/*// Java Code to Merge two sorted arrays a[] and b[] without 
// extra space using insert of insertion sort

import java.util.Arrays;

class GfG {
    
    static void mergeArrays(int[] a, int[] b) {
      
        // Traverse b[] starting from the last element
        for (int i = b.length - 1; i >= 0; i--) {
          
            // If b[i] is smaller than the largest element of a[]
            if (a[a.length - 1] > b[i]) {
              
                // Place b[i] in the correct position in a[], 
                // and move last element of a[] to b[]
                int last = a[a.length - 1];
                int j = a.length - 2;
                while (j >= 0 && a[j] > b[i]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArrays(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
}*/