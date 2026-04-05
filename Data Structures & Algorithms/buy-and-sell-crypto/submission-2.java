class Solution {
    public int maxProfit(int[] prices) {
        int[] minPrice = new int[prices.length];
        int min = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            maxProfit = Math.max(prices[i]-min,maxProfit);
            min = Math.min(min,prices[i]);
        }

        return maxProfit;
    }
}
