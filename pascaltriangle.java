/*Given a positive integer n, return the nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.    
Examples:
Input: n = 4
Output: [1, 3, 3, 1]
Explanation: 4th row of pascal's triangle is [1, 3, 3, 1].
Input: n = 5
Output: [1, 4, 6, 4, 1]
Explanation: 5th row of pascal's triangle is [1, 4, 6, 4, 1].
Input: n = 1
Output: [1]
Explanation: 1st row of pascal's triangle is [1].   */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class pascaltriangle {

    // Method to get nth row of Pascal's Triangle
    public static ArrayList<BigInteger> nthRowOfPascalTriangle(int n) {
        ArrayList<BigInteger> row = new ArrayList<>();
        BigInteger val = BigInteger.ONE;
        row.add(val);  // First element is always 1

        for (int k = 1; k < n; k++) {
            val = val.multiply(BigInteger.valueOf(n - k));
            val = val.divide(BigInteger.valueOf(k));
            row.add(val);
        }

        return row;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a positive integer n: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Error: n must be a positive integer.");
                return;
            }

            ArrayList<BigInteger> row = nthRowOfPascalTriangle(n);
            System.out.println("The " + n + "th row of Pascal's Triangle is:");
            System.out.println(row);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid positive integer.");
        } finally {
            scanner.close();
        }
    }
}
