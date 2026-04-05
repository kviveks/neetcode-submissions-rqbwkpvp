class Solution {
    public int maxProfit(int[] prices) {

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for(int i=1;i<prices.length;i++){
            int prehold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prehold,prevRest-prices[i]);
            sold = prehold + prices[i];
            rest = Math.max(prevRest, prevSold);

        }

        return Math.max(rest,sold);
        
    }
}
