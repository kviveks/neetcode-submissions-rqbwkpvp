class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount+1;
        int[][] dp = new int[m][n];


        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }

        for(int j=1;j<n;j++){
            if(j%coins[0]==0){
                dp[0][j]=1;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=(j-coins[i]>=0?dp[i][j-coins[i]]:0)+dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
}
