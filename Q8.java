/*Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.
Note: Stock must be bought before being sold.
Examples:
Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
Output: 8
Explanation: You can buy the stock on day 2 at price = 1 and sell it on day 5 at price = 9. Hence, the profit is 8.
Input: prices[] = [7, 6, 4, 3, 1]
Output: 0 
Explanation: Here the prices are in decreasing order, hence if we buy any day then we cannot sell it at a greater price. Hence, the answer is 0.
Input: prices[] = [1, 3, 6, 9, 11]
Output: 10 
Explanation: Since the array is sorted in increasing order, we can make maximum profit by buying at price[0] and selling at price[n-1].*/
import java.util.Scanner;

class Q8 {
    public int maximumProfit(int prices[]) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minprice = prices[0];
        int maxprofit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else {
                int profit = prices[i] - minprice;
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the number of days: ");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Number of days must be positive.");
                return;
            }

            int prices[] = new int[n];
            System.out.println("Enter the prices for each day:");
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }
            Q8 sol = new Q8();
            int result = sol.maximumProfit(prices);
            System.out.println("Maximum Profit: " + result);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            sc.close(); // Always good to close Scanner
        }
    }
}
