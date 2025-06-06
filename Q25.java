/*Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.

Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Examples:

Input: intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
Output: [[1,3], [4,7], [8,10]]
Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
Output: [[1,2], [3,10], [12,16]]
Explanation: The new interval [4,9] overlaps with [3,5],[6,7],[8,10].*/
import java.util.*;

public class Q25 {
    public static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add intervals that come before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input intervals
        System.out.print("Enter number of intervals: ");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        System.out.println("Enter the intervals (start end):");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        // Input new interval
        System.out.print("Enter the new interval (start end): ");
        int[] newInterval = new int[2];
        newInterval[0] = sc.nextInt();
        newInterval[1] = sc.nextInt();

        // Process and print result
        ArrayList<int[]> result = insertInterval(intervals, newInterval);
        System.out.println("Merged intervals:");
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
/*import java.util.*;

class GfG {

    // Function to merge overlapping intervals
    static ArrayList<int[]> mergeOverlap(int[][] intervals) {

        // Sort intervals based on start values
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        ArrayList<int[]> res = new ArrayList<>();

        // Insert the first interval into the result
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            
            // Find the last interval in the result
            int[] last = res.get(res.size() - 1);
            int[] curr = intervals[i];

            // If current interval overlaps with the last interval
            // in the result, merge them 
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } 
            else {
                res.add(curr);
            }
        }

        return res;
    }

    static ArrayList<int[]> insertInterval(int[][] intervals, 
                                            int[] newInterval) {
        
        // Create a new ArrayList to hold the intervals
        ArrayList<int[]> intervalList = 
                new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);
        return mergeOverlap(intervalList.toArray(new int[0][]));
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval = {5, 6};

        ArrayList<int[]> res = insertInterval(intervals, newInterval);
        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}*/
/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GfG {

    // Function to insert and merge intervals
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Add all the remaining intervals
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Return the result as a List<int[]>
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval = {5, 6};

        ArrayList<int[]> res = insertInterval(intervals, newInterval);
        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}*/