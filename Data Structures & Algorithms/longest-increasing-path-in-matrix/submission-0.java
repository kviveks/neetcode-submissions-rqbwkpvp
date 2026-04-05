class Solution {
    int res = Integer.MIN_VALUE;
    int row;
    int col;
    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        int[][] dp = new int[row][col];

        for(int i = 0;i<row;i++){
            for(int j =0;j<col;j++){
                dp[i][j]=dfs(i,j,dp,matrix,-1);
            }
        } 

        return res; 
    }

    public int dfs(int r,int c,int[][] dp,int[][] matrix,int prev){

        if(matrix[r][c] <= prev){
            return 0;
        }

        if(dp[r][c]!=0){
            return dp[r][c];
        }

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int path =1;
        for(int[] dir : dirs){
            if(dir[0]+r>=0 && dir[0]+r<row && dir[1]+c >=0 && dir[1]+c < col){
                path = Math.max(path,1+dfs(dir[0]+r,dir[1]+c,dp,matrix,matrix[r][c]));
            }        
        }
        res = Math.max(path,res);
        dp[r][c] = path;

        return path;
    }
}
