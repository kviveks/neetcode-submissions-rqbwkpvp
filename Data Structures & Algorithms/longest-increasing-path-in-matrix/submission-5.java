class Solution {
    int res = 1;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(i,j,dp,matrix,Integer.MIN_VALUE);
            }
        }

        return res;
    }

    public int dfs(int x,int y,int[][] dp,int[][] matrix,int prevValue){
        int m = matrix.length;
        int n = matrix[0].length;
        if(x<0||x>=m||y<0||y>=n||matrix[x][y]<=prevValue){
            return 0;
        }

        if(dp[x][y]!=0){
            return dp[x][y];
        }

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

        int value = 0;
        for(int[] dir : dirs){
            value = Math.max(dfs(x+dir[0],y+dir[1],dp,matrix,matrix[x][y]),value);
        }

        value = value+1;

        dp[x][y]=value;
        res=Math.max(res,value);
        return value;

    }
}
