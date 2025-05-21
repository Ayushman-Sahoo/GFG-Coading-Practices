/*Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, "act" and "tac" are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.
Note: You can assume both the strings s1 & s2 are non-empty.
Examples :
Input: s1 = "geeks", s2 = "kseeg"
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.
Input: s1 = "allergy", s2 = "allergic"
Output: false
Explanation: Characters in both the strings are not same, so they are not anagrams.
Input: s1 = "g", s2 = "g"
Output: true
Explanation: Character in both the strings are same, so they are anagrams*/
import java.util.Scanner;

public class Q16 {
    // Function to check whether two strings are anagram of each other or not
    public static boolean areAnagrams(String s1, String s2) {
        // If lengths are not equal, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] count = new int[26];

        // Count characters: increment for s1 and decrement for s2
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two strings from user
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine().toLowerCase();

        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine().toLowerCase();

        // Check and print result
        if (areAnagrams(s1, s2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
