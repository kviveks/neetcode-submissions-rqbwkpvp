class Solution {
    int res = 1;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(dp[i][j]==0){
                    dfs(i,j,dp,matrix);
                }
            }
        }

        return res+1;
    }

    public int dfs(int x,int y,int[][] dp,int[][] matrix){
        if(dp[x][y]!=0){
            return dp[x][y];
        }


        int[][] dirs ={{-1,0},{1,0},{0,-1},{0,1}};
        int value = 0;
        for(int[] dir : dirs){
            int x_ = dir[0];
            int y_ = dir[1];
            if(x+x_<0||x+x_>=matrix.length||y+y_<0||y+y_>=matrix[0].length){
                continue;
            }
            if(matrix[x+x_][y+y_]>matrix[x][y]){
                value = Math.max(1+dfs(x+x_,y+y_,dp,matrix),value);
            }
        }
        dp[x][y]=value;
        res=Math.max(res,value);
        return value;
    }
}
