/*Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Examples:
Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
Output: 1
Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.
Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
Output: 2
Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.
Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
Output: 0
Explanation: All ranges are already non overlapping.*/
import java.util.*;

public class Q26 {
    static int minRemoval(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort by end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                count++; // overlap, remove
            } else {
                lastEnd = intervals[i][1]; // update last end
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of intervals
        System.out.print("Enter number of intervals: ");
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];
        System.out.println("Enter each interval as two space-separated integers (start end):");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        int result = minRemoval(intervals);
        System.out.println("Minimum number of intervals to remove: " + result);
    }
}
/*// Java program to minimum number of intervals required 
// to be removed to make remaining intervals non-overlapping
// Using sorting by starting value
import java.util.*;

class GfG {
    static int minRemoval(int[][] intervals) {
        int cnt = 0;
      
        // Sort by minimum starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            // If the current starting point is less than
            // the previous interval's ending point
            // (ie. there is an overlap)
            if (intervals[i][0] < end) {
              
                // Increase cnt and remove the interval
                // with the higher ending point
                cnt++;
                end = Math.min(intervals[i][1], end);
            }

            // Incase of no overlapping, this interval is 
            // not removed and 'end' will be updated
            else
                end = intervals[i][1];
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(intervals));
    }
}*/
/*// Java program to minimum number of intervals required 
// to be removed to make remaining intervals non-overlapping
// Using sorting by ending value

import java.util.*;

class GfG {
  
    static int minRemoval(int[][] intervals) {
        int cnt = 0;

        // Sort by minimum ending point
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // if there is an overlap increase the count
            if (intervals[i][0] < end)
                cnt++;

            // else increment the ending point
            else
                end = intervals[i][1];
        }

        // return the count
        return cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 5}, {1, 4}};
        System.out.println(minRemoval(intervals));
    }
}*/