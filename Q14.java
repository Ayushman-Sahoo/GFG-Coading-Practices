/*Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.
Cases for atoi() conversion:
Skip any leading whitespaces.
Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.
Examples:
Input: s = "-123"
Output: -123
Explanation: It is possible to convert -123 into an integer so we returned in the form of an integer
Input: s = "  -"
Output: 0
Explanation: No digits are present, therefore the returned answer is 0.
Input: s = " 1231231231311133"
Output: 2147483647
Explanation: The converted number will be greater than 231 – 1, therefore print 231 – 1 = 2147483647.
Input: s = "-999999999999"
Output: -2147483648
Explanation: The converted number is smaller than -231, therefore print -231 = -2147483648.
Input: s = "  -0012gfg4"
Output: -12
Explanation: Nothing is read after -12 as a non-digit character ‘g’ was encountered. */
import java.util.Scanner;

public class Q14 {
    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;

        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check for optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // Read and convert digits
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + (s.charAt(i) - '0');

            // Clamp to 32-bit integer range
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(sign * result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a string to convert to integer: ");
            String input = scanner.nextLine();
            int result = myAtoi(input);
            System.out.println("Converted Integer: " + result);
        } catch (Exception e) {
            System.out.println("An error occurred during conversion: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
/*class GfG {
    static int myAtoi(String s) {
        int sign = 1, res = 0, idx = 0;
// Ignore leading whitespaces
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }
// Store the sign of number
        if (idx < s.length() && (s.charAt(idx) == '-' 
                                 || s.charAt(idx) == '+')) {
            if (s.charAt(idx++) == '-') {
                sign = -1;
            }
        }
// Construct the number digit by digit
        while (idx < s.length() && s.charAt(idx) >= '0' 
               						&& s.charAt(idx) <= '9') {
            
            // Handling overflow/underflow test case
            if (res > Integer.MAX_VALUE / 10 || 
                   (res == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
          
            // Append current digit to the result
            res = 10 * res + (s.charAt(idx++) - '0');
        }
        return res * sign;
    }

    public static void main(String[] args) {
        String s = "  -0012g4";
        System.out.println(myAtoi(s));
    }
}*/