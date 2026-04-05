class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }

        return count;
    }

    public void dfs(int x,int y, char[][] grid){
        
        grid[x][y]='0';
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};


        for(int[] dir : dirs){
            int x_ = x+dir[0];
            int y_ = y+dir[1];
            if(x_ < 0 || y_ < 0 || x_ >= grid.length || y_ >= grid[0].length || grid[x_][y_]=='0'){
                continue;
            }
            dfs(x_,y_,grid);
        }
    }
}
