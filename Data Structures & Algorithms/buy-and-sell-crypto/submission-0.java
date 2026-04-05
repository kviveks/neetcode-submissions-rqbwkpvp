class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        int[] left = new int[l];
        left[0] = Integer.MAX_VALUE;
        for(int i = 1;i<l;i++){
            left[i] = Math.min(left[i-1],prices[i-1]);
        }

        int profit = 0;

        for(int i = 0;i<l;i++){
            profit=Math.max(profit,prices[i]-left[i]);
        }

        return profit;
        
    }
}
