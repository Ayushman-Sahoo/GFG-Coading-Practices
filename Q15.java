/*Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110*/
import java.util.Scanner;

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0;

            int sum = bit1 + bit2 + carry;
            result.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        String res = result.reverse().toString().replaceFirst("^0+(?!$)", "");
        return res;
    }
}

public class Q15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first binary string: ");
        String s1 = scanner.nextLine().trim();

        System.out.print("Enter second binary string: ");
        String s2 = scanner.nextLine().trim();

        if (!s1.matches("[01]+") || !s2.matches("[01]+")) {
            System.out.println("Invalid input! Only binary digits (0 and 1) are allowed.");
            return;
        }

        Solution sol = new Solution();
        String result = sol.addBinary(s1, s2);
        System.out.println("Sum: " + result);
    }
}
/*// Java program to add two binary strings
// using Bit-by-Bit addition
class GfG {

    // Function to trim leading zeros from a binary string
    static String trimLeadingZeros(String s) {

        // Find the position of the first '1'
        int firstOne = s.indexOf('1');
        return (firstOne == -1) ? "0"
                                : s.substring(firstOne);
    }

    // This function adds two binary strings and return
    // result as a third string
    static String addBinary(String s1, String s2) {
      
        // Trim Leading Zeros
        s1 = trimLeadingZeros(s1);
        s2 = trimLeadingZeros(s2);
        
        int n = s1.length();
        int m = s2.length();

        // Swap the strings if s1 is of smaller length
        if (n < m) {
            return addBinary(s2, s1);
        }

        int j = m - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        // Traverse both strings from the end
        for (int i = n - 1; i >= 0; i--) {

            // Current bit of s1
            int bit1 = s1.charAt(i) - '0';
            int sum = bit1 + carry;

            // If there are remaining bits in s2, add them
            // to the sum
            if (j >= 0) {

                // Current bit of s2
                int bit2 = s2.charAt(j) - '0';
                sum += bit2;
                j--;
            }

            // Calculate the result bit and update carry
            int bit = sum % 2;
            carry = sum / 2;

            // Update the current bit in result
            result.append((char)(bit + '0'));
        }

        // If there's any carry left, update the result
        if (carry > 0)
            result.append('1');

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "1101";
        String s2 = "111";

        System.out.println(addBinary(s1, s2));
    }
}*/
