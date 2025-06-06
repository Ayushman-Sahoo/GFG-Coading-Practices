/*Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.
Note: A palindrome string is a sequence of characters that reads the same forward and backward.
Examples:
Input: s = "abc"
Output: 2
Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
Input: s = "aacecaaaa"
Output: 2
Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"*/
import java.util.Scanner;

public class Q19 {

    public static int minChar(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;
        int[] lps = computeLPS(temp);
        return s.length() - lps[temp.length() - 1];
    }

    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        int result = minChar(s);
        System.out.println("Minimum characters to add at front to make it palindrome: " + result);
    }
}
/*// Java program for counting minimum character to be
// added at front to make string palindrome
class GfG {

    // Function to check if the substring s[i...j] is a palindrome
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            
            // If characters at the ends are not the same, it's not a palindrome
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int minChar(String s) {
        int cnt = 0;
        int i = s.length() - 1;
        
        // Iterate from the end of the string, checking for the longest 
        // palindrome starting from the beginning
        while (i >= 0 && !isPalindrome(s, 0, i)) {
            
            i--;
            cnt++;
        }
        
        return cnt;
    }

    public static void main(String[] args) {
        String s = "AACECAAAA";
        
        System.out.println(minChar(s));
    }
}*/
/*// Java program for getting minimum character to be
// added at front to make string palindrome

import java.util.ArrayList;
class GfG {

    static int[] computeLPSArray(String pat) {
        int n = pat.length();
        int[] lps = new int[n];

        // lps[0] is always 0
        lps[0] = 0;
        int len = 0;

        // loop calculates lps[i] for i = 1 to n-1
        int i = 1;
        while (i < n) {

            // If the characters match, increment len
            // and set lps[i]
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            // If there is a mismatch
            else {

                // If len is not zero, update len to
                // the last known prefix length
                if (len != 0) {
                    len = lps[len - 1];
                }

                // No prefix matches, set lps[i] to 0
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Method returns minimum character to be added at
    // front to make string palindrome
    static int minChar(String s) {
        int n = s.length();
        String rev
            = new StringBuilder(s).reverse().toString();

        // Get concatenation of string, special character
        // and reverse string
        s = s + "$" + rev;

        // Get LPS array of this concatenated string
        int[] lps = computeLPSArray(s);

        // By subtracting last entry of lps array from
        // string length, we will get our result
        return (n - lps[lps.length - 1]);
    }

    public static void main(String[] args) {
        String s = "AACECAAAA";
        System.out.println(minChar(s));
    }
}*/