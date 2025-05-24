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
