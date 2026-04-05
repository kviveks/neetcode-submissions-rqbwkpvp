public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // Initialize the DP arrays
        int[] hold = new int[n];     // hold[i] means the maximum profit on day i if holding a coin
        int[] sold = new int[n];     // sold[i] means the maximum profit on day i if sold the coin
        int[] cooldown = new int[n]; // cooldown[i] means the maximum profit on day i if in cooldown

        // Base cases for day 0
        hold[0] = -prices[0];  // If we buy on day 0
        sold[0] = 0;           // No profit if we don't sell
        cooldown[0] = 0;       // No profit if we're in cooldown

        // Iterate over each day from 1 to n-1
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]);
            sold[i] = hold[i - 1] + prices[i];
            cooldown[i] = Math.max(cooldown[i - 1], sold[i - 1]);
        }

        // The result is the max profit from either selling or being in cooldown on the last day
        return Math.max(sold[n - 1], cooldown[n - 1]);
    }
}
