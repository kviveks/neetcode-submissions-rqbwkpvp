class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];


        for(int i = 1;i<=amount;i++){
            int min = Integer.MAX_VALUE;   
            for(Integer coin : coins){
                if(i-coin>=0){
                min = Math.min(min,dp[i-coin]+1);
                }
            }
                dp[i] = min;
        } 
        if(dp[amount] = Integer.MAX_VALUE){
            returnn -1;
        }
        return dp[amount];                                                            
        
    }
}
