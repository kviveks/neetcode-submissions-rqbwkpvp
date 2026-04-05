class Solution {
    private int row;
    private int col;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        int currArea = 0;

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1){
                    currArea = dfs(i,j,grid,0);
                    maxArea = Math.max(maxArea,currArea);
                    currArea=0;
                }
            }
        }

        return maxArea;    
    }

    public int dfs(int i,int j,int[][] grid,int currArea){
        if(i < 0 || i >= row || j < 0 || j >= col){
            return currArea;
        }

        if(grid[i][j]==0){
            return currArea;
        }

        currArea++;
        grid[i][j]=0;

        return currArea + dfs(i+1,j,grid,0) + dfs(i-1,j,grid,0) + dfs(i,j+1,grid,0) + dfs(i,j-1,grid,0);
    }
}
