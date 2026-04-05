class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentmin = prices[0];
        for(int i = 1;i<prices.length;i++){
            maxProfit = Math.max(maxProfit,prices[i]-currentmin);
            currentmin = Math.min(prices[i],currentmin);
        }

        return maxProfit;
    
    }
}
