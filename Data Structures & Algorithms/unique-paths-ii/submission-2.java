class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;


        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];


        int i=0;
        int j=0;
        dp[0][0]=1;

        for(i=1;i<m;i++){
            if(obstacleGrid[i][j]==0){
                dp[i][j]=dp[i-1][j];
            }
        }
        i=0;
        for(j=1;j<n;j++){
            if(obstacleGrid[i][j]==0){
                dp[i][j]=dp[i][j-1];
            }
        }


        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}