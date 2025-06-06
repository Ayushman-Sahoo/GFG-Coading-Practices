/*Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.
H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.
Examples:
Input: citations[] = [3, 0, 5, 3, 0]
Output: 3
Explanation: There are at least 3 papers (3, 5, 3) with at least 3 citations.
Input: citations[] = [5, 1, 2, 4, 1]
Output: 2
Explanation: There are 3 papers (with citation counts of 5, 2, and 4) that have 2 or more citations. However, the H-Index cannot be 3 because there aren't 3 papers with 3 or more citations.
Input: citations[] = [0, 0]
Output: 0 */
import java.util.Arrays;
import java.util.Scanner;

public class Q22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of papers
        System.out.print("Enter number of papers: ");
        int n = sc.nextInt();

        int[] citations = new int[n];

        System.out.println("Enter citations for each paper:");
        for (int i = 0; i < n; i++) {
            citations[i] = sc.nextInt();
        }

        int hIndex = findHIndex(citations);
        System.out.println("H-Index: " + hIndex);
    }

    public static int findHIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int papersWithAtLeastThisManyCitations = n - i;
            if (citations[i] >= papersWithAtLeastThisManyCitations) {
                h = Math.max(h, papersWithAtLeastThisManyCitations);
            }
        }

        return h;
    }
}
/*
import java.util.Arrays;
class GfG {
    static int hIndex(int[] citations) {
        // Sort the citations in descending order
        Arrays.sort(citations);
        int n = citations.length;
        int idx = 0;

        // Keep incrementing idx till citations[n - 1 - idx] > idx
        while (idx < n && citations[n - 1 - idx] > idx) {
            idx++;
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] citations = {6, 0, 3, 5, 3};
        System.out.println(hIndex(citations));
    }
}*/

/*import java.util.Arrays;

class GfG {
    static int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];

        // Count the frequency of citations
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n)
                freq[n] += 1;
            else
                freq[citations[i]] += 1;
        }

        int idx = n;
        
        // Variable to keep track of the count of papers
        // having at least idx citations
        int s = freq[n]; 
        while (s < idx) {
            idx--;
            s += freq[idx];
        }
        
        // Return the largest index for which the count of 
        // papers with at least idx citations becomes >= idx
        return idx;
    }

    public static void main(String[] args) {
        int[] citations = {6, 0, 3, 5, 3};
        System.out.println(hIndex(citations));
    }
}*/