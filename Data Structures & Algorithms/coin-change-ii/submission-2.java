class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];


        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=1;
            }
        }

        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j<coins[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i][j-coins[i]]+dp[i-1][j];
                }
            }
        }


        return dp[coins.length-1][amount];
    }
}
