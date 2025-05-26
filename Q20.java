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
