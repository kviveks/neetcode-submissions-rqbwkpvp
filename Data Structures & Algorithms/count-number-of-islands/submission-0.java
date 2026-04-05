class Solution {
    private int row;
    private int col;
    public int numIslands(char[][] grid) {
        int count = 0;
        row = grid.length;
        col = grid[0].length;

        for(int i = 0; i<row; i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
        
    }

    public void dfs(int i,int j,char[][] grid){
        
        if(i<0 || i>=row || j<0 || j>=col){
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        if(grid[i][j]=='1'){
            grid[i][j] = '0';
        }

        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}
