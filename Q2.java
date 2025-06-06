/*You are given an array arr[] of non-negative integers. Your task is to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements. The operation must be performed in place, meaning you should not use extra space for another array.
Examples:
Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.
Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]
Explanation: No change in array as there are no 0s.
Input: arr[] = [0, 0]
Output: [0, 0]
Explanation: No change in array as there are all 0s. */
import java.util.Scanner;
import java.util.Arrays;

class ZeroMover {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Shift all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        // Fill the rest with zeros
        while (count < n) {
            arr[count++] = 0;
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        try {
            System.out.print("Enter the size of the array: ");
            n = sc.nextInt();

            if (n < 0) {
                System.out.println("Size cannot be negative.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " non-negative integers:");

            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                if (value < 0) {
                    System.out.println("Only non-negative integers are allowed.");
                    return;
                }
                arr[i] = value;
            }

            ZeroMover mover = new ZeroMover();
            mover.pushZerosToEnd(arr);

            System.out.println("Array after pushing zeros to the end:");
            System.out.println(Arrays.toString(arr));

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            sc.close();
        }
    }
}
