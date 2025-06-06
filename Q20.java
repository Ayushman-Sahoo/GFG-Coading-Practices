/*You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.
Note: The characters in the strings are in lowercase.
Examples :
Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.
Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.
Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other. */
import java.util.Scanner;

public class Q20 {

    // Main method to take user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string (s1): ");
        String s1 = sc.nextLine();

        System.out.print("Enter the second string (s2): ");
        String s2 = sc.nextLine();

        if (areRotations(s1, s2)) {
            System.out.println("Output: true");
            System.out.println("Explanation: \"" + s2 + "\" is a rotation of \"" + s1 + "\".");
        } else {
            System.out.println("Output: false");
            System.out.println("Explanation: \"" + s2 + "\" is not a rotation of \"" + s1 + "\".");
        }

        sc.close();
    }

    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        String combined = s1 + s1;
        return kmpSearch(combined, s2);
    }

    // KMP substring search
    private static boolean kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // Function to build LPS array for pattern
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
/*// Java program to check two strings for rotation
// by generating all rotations
class GfG {
    
    // Function to check if s1 and s2 are rotations of each other
    static boolean areRotations(String s1, String s2) {
        int n = s1.length();

        // Generate and check all possible rotations of s1
        for (int i = 0; i < n; ++i) {
            
            // If current rotation is equal to s2, return true
            if (s1.equals(s2)) {
                return true;
            }

            // Right rotate s1
            char last = s1.charAt(s1.length() - 1);
            s1 = last + s1.substring(0, s1.length() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aba";

        System.out.println(areRotations(s1, s2));
    }
}*/
/*// Java program to check if two given strings are rotations 
// of each other using KMP Algorithm

import java.util.Arrays;

class GfG {
    
    static int[] computeLPSArray(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
      
        // Length of the previous longest prefix suffix
        int len = 0;

        // lps[0] is always 0
        lps[0] = 0;

        // loop calculates lps[i] for i = 1 to n-1
        int i = 1;
        while (i < n) {
          
            // If the characters match, increment len 
            // and extend the matching prefix
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
          
            // If there is a mismatch
            else {
              
                // If len is not zero, update len to
                // last known prefix length
                if (len != 0) {
                    len = lps[len - 1];
                }
              
                // No prefix matches, set lps[i] = 0
                // and move to the next character
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Function to check if s1 and s2 are rotations of each other
    static boolean areRotations(String s1, String s2) {
        String txt = s1 + s1;
        String pat = s2;
        
        // search the pattern string s2 in the concatenation string 
        int n = txt.length();
        int m = pat.length();

        // Create lps[] that will hold the longest prefix suffix
        // values for pattern
        int[] lps = computeLPSArray(pat);
      
        int i = 0; 
        int j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == m) {
                return true;
            }

            // Mismatch after j matches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {

                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aab"; 
        String s2 = "aba";
        
        System.out.println(areRotations(s1, s2) ? "true" : "false");
    }
}*/
/*// Java program to check if two given strings are rotations of each other
class GfG {

    // Function to check if s1 and s2 are rotations of each other
    static boolean areRotations(String s1, String s2) {
        s1 = s1 + s1;

        // find s2 in concatenated string
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aba";

        System.out.println(areRotations(s1, s2));
    }
}*/