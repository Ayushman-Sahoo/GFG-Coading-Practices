/*Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.
Examples:
Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
Output: [[1,4], [6,8], [9,10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
Output: [[1,9]]
Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9]. */
import java.util.*;

public class Q24 {
    public List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;

        // Sort by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= current[1]) {
                current[1] = Math.max(current[1], arr[i][1]);
            } else {
                result.add(current);
                current = arr[i];
            }
        }

        result.add(current);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q24 obj = new Q24();

        System.out.print("Enter number of intervals: ");
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        System.out.println("Enter the intervals (start and end):");
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        List<int[]> merged = obj.mergeOverlap(arr);

        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GfG {

    static List<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();

        // Checking for all possible overlaps
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            // Skipping already merged intervals
            if (!res.isEmpty() && res.get(res.size() - 1)[1] >= end) {
                continue;
            }

            // Find the end of the merged range
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                }
            }
            res.add(new int[]{start, end});
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        List<int[]> res = mergeOverlap(arr);

        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}*/
/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GfG {

    static List<int[]> mergeOverlap(int[][] arr) {
        
        // Sort intervals based on start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < arr.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = arr[i];

            // If current interval overlaps with the last merged 
            // interval, merge them 
            if (curr[0] <= last[1]) 
                last[1] = Math.max(last[1], curr[1]);
            else 
                res.add(new int[]{curr[0], curr[1]});
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        List<int[]> res = mergeOverlap(arr);

        for (int[] interval : res) 
            System.out.println(interval[0] + " " + interval[1]);
    }
}*/
/*import java.util.Arrays;

class GfG {

    // Merge overlapping intervals in-place. We return
    // modified size of the array arr.
    static int mergeOverlap(int[][] arr) {

        // Sort intervals based on start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Index of the last merged 
        int resIdx = 0; 

        for (int i = 1; i < arr.length; i++) {
            
            // If current interval overlaps with the 
            // last merged interval
            if (arr[resIdx][1] >= arr[i][0])           
                arr[resIdx][1] = Math.max(arr[resIdx][1], arr[i][1]);
            
            // Move to the next interval
            else {            
                resIdx++;
                arr[resIdx] = arr[i];
            }
        }

        // Returns size of the merged intervals
        return (resIdx + 1);
    }

    public static void main(String[] args) {
        int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        
        // Get the new size of the array after merging
        int newSize = mergeOverlap(arr);

        // Print the merged intervals based on the new size
        for (int i = 0; i < newSize; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}*/