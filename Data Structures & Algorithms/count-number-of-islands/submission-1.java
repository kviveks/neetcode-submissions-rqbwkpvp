class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;    
    }

    public void dfs(int x,int y,char[][] grid){
        if(x>=grid.length || x <0 || y>=grid[0].length || y<0){
            return;
        }
        if(grid[x][y]=='0'){
            return;
        }

        grid[x][y]='0';
        dfs(x+1,y,grid);
        dfs(x-1,y,grid);
        dfs(x,y+1,grid);
        dfs(x,y-1,grid);
    }
}
