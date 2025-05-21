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
