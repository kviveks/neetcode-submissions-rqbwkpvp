class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        int[][] dp = new int[l][l];

        for(int i = 0 ;i< l ;i++){
            dp[0][i]= prices[i]-prices[0];
        }

        int max;
        int profit;
        for(int i = 1;i < l ;i++){
            for(int j = 0;j< l;j++){
                if(j<i){
                    dp[i][j]=dp[i-1][j];
                    continue;
                }
                max = Math.max(dp[i-1][j],dp[i][j-1]);
                profit = prices[i]-prices[j];
                if(j-2>=0){
                    profit = profit+ dp[i-1][j-2];
                }

                dp[i][j] = Math.max(Math.max(max,profit),0);
                
            }
        }

        return dp[l-1][l-1];
        
    }
}
