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
/*// Java Code to check if two Strings are anagrams of 
// each other using sorting

import java.util.Arrays;

class GfG {

    // Function to check if two strings are anagrams
    static boolean areAnagrams(String s1, String s2) {
        
        // Sort both strings
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        // Compare sorted strings
        return Arrays.equals(s1Array, s2Array);
    }

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";
        System.out.println(areAnagrams(s1, s2));
    }
}*/
/*// Java Code to check if two Strings are anagram of 
// each other using Hash map

import java.util.HashMap;

class GfG {
    
    static boolean areAnagrams(String s1, String s2) {
        
        // Create a hashmap to store character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // Count frequency of each character in string s1
        for (char ch : s1.toCharArray()) 
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
  
        // Count frequency of each character in string s2
        for (char ch : s2.toCharArray()) 
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
  
        // Check if all frequencies are zero
        for (var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }
        
        // If all conditions satisfied, they are anagrams
        return true;
    }

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";
        System.out.println(areAnagrams(s1, s2) ? "true" : "false");
    }
}*/
/*// Java Code to check if two Strings are anagram of 
// each other using Frequency Array

class GfG {

    // As the input strings can only have lowercase 
    // characters, the maximum characters will be 26
    static final int MAX_CHAR = 26;

    static boolean areAnagrams(String s1, String s2) {
        int[] freq = new int[MAX_CHAR];

        // Count frequency of each character in string s1
        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;

        // Count frequency of each character in string s2
        for (int i = 0; i < s2.length(); i++)
            freq[s2.charAt(i) - 'a']--;

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";
        System.out.println(areAnagrams(s1, s2));
    }
}*/