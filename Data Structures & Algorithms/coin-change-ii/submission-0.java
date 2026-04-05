class Solution {
    public int change(int amount, int[] coins) {

        int l = coins.length;

        int[][] dp = new int[l][amount+1];


        for(int i = 0;i<l;i++){
            dp[i][0] = 1;
        }

        for(int i = 1;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i] = 1;
            }
        }
        int coin;

        for(int i = 1 ; i<l;i++){
            coin = coins[i];
            for(int j = 1; j<=amount; j++){
                if(j<coin){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coin];
                }
            }
        }

        return dp[l-1][amount];
        
    }
}
