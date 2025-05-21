/*The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.
Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.
Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
Output: 865
Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.
Input: prices[] = [4, 2, 2, 2, 4]
Output: 2
Explanation: Buy the stock on day 3 and sell it on day 4 => 4 – 2 = 2. Maximum Profit = 2.*/
import java.util.Scanner;
class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int profit = 0;
        
        for (int i = 1; i < n; i++) {  // Start from i = 1 to avoid index -1
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Enter number of days:");
            int n = sc.nextInt();
            
            if (n <= 0) {
                System.out.println("Number of days must be positive!");
                return;
            }
            
            int[] prices = new int[n];
            System.out.println("Enter the stock prices:");
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
                if (prices[i] < 0) {
                    System.out.println("Stock prices cannot be negative!");
                    return;
                }
            }
            
            Solution sol = new Solution();
            int maxProfit = sol.maximumProfit(prices);
            System.out.println("Maximum Profit: " + maxProfit);
            
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter integers only.");
        } finally {
            sc.close();
        }
    }
}
