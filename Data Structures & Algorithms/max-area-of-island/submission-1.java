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
                    currArea = dfs(i,j,grid);
                    maxArea = Math.max(maxArea,currArea);
                    currArea=0;
                }
            }
        }

        return maxArea;    
    }

    public int dfs(int i,int j,int[][] grid){
        if(i < 0 || i >= row || j < 0 || j >= col){
            return 0;
        }

        if(grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;

        return 1 + dfs(i+1,j,grid) + dfs(i-1,j,grid) + dfs(i,j+1,grid) + dfs(i,j-1,grid);
    }
}
