/*Non Repeating Character
Given a string s consisting of lowercase English Letters. Return the first non-repeating character in s.
If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: -1
Explanation: All the characters in the given string are repeating. */
import java.util.*;

public class Q17 {
    public static char firstNonRepeatingChar(String s) {
        // Store character counts
        int[] freq = new int[26];
        
        // First pass: count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Second pass: find first character with count 1
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c;
            }
        }

        return '$'; // No non-repeating character
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine().trim();

        char result = firstNonRepeatingChar(s);
        
        if (result == '$') {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
/*public class GFG {

    public static char nonRep(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            boolean found = false;

            for (int j = 0; j < n; ++j) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found) 
                return s.charAt(i);
        }

        return '$';
    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(nonRep(s));
    }
}*/
/*import java.util.*;

public class GFG {
    private static final int MAX_CHAR = 26;  

    public static char nonRep(String s) {
        int[] freq = new int[MAX_CHAR];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Find the first character with frequency 1
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c;
            }
        }
        return '$';
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(nonRep(s));
    }
}*/
/*import java.util.*;

public class Main {
    static final int MAX_CHAR = 26;

    public static char nonRep(String s) {
        int[] vis = new int[MAX_CHAR];
        Arrays.fill(vis, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (vis[index] == -1) {
                
                  // Store the index when character is first seen
                vis[index] = i;
            } else {
                
                // Mark character as repeated
                vis[index] = -2;  
            }
        }

        int idx = -1;

        // Find the smallest index of the non-repeating characters
        for (int i = 0; i < MAX_CHAR; i++) {
            if (vis[i] >= 0 && (idx == -1 || vis[i] < vis[idx])) {
                idx = i;
            }
        }

        return (idx == -1) ? '$' : s.charAt(vis[idx]);
    }

    public static void main(String[] args) {
        String s = "aabbccc";
        System.out.println(nonRep(s));
    }
}*/