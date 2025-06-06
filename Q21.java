/*Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
You need to solve this problem without utilizing the built-in sort function.
Examples
Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.

Follow up: Could you come up with a one-pass algorithm using only constant extra space? */
import java.util.Scanner;

public class Q21 {
    
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid], then increment both
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high], decrement high
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q21 obj = new Q21();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements (only 0s, 1s, and 2s):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 0 || arr[i] > 2) {
                System.out.println("Invalid input! Only 0, 1, or 2 are allowed.");
                return;
            }
        }

        obj.sort012(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
/*// Java Program to sort an array of 0s, 1s and 2s
// by counting the occurrence of 0s, 1s and 2s

class GfG {
  
    // Function to sort the array of 0s, 1s and 2s
    static void sort012(int[] arr) {
        int n = arr.length;
        int c0 = 0, c1 = 0, c2 = 0;

        // Count 0s, 1s and 2s
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) 
                c0 += 1;
            else if (arr[i] == 1) 
                c1 += 1;
            else 
                c2 += 1;
        }

        int idx = 0;
      
        // Place all the 0s
        for (int i = 0; i < c0; i++)
            arr[idx++] = 0;

        // Place all the 1s
        for (int i = 0; i < c1; i++)
            arr[idx++] = 1;

        // Place all the 2s
        for (int i = 0; i < c2; i++)
            arr[idx++] = 2;
    }
  
    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 0, 1, 2 };
        int n = a.length;

        sort012(a);

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}*/
/*// Java program to sort an array of 0s, 1s and 2s 
// using Dutch National Flag Algorithm

import java.util.ArrayList;
import java.util.Arrays;
class GfG {

    // Function to sort an array of 0s, 1s and 2s
    static void sort012(int[] arr) {
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int mid = 0, temp = 0;

        // Iterate till all the elements are sorted
        while (mid <= hi) {
            if (arr[mid] == 0) {
                swap(arr, mid, lo);
                lo++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, hi);
                hi--;
            }
        }
    }
	
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 1, 2 };
        sort012(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
} */