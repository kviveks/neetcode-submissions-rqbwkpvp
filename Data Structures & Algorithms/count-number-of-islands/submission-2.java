class Solution {
    int res = 0;
    public int numIslands(char[][] grid) {
        for(int i =0;i<grid.length;i++){
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
        if(x<0 || x >=grid.length || y<0 || y>=grid[0].length){
            return;
        }

        if(grid[x][y]!='1'){
            return;
        }

        grid[x][y]='0';

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        for(int[] dir : dirs){
            dfs(x+dir[0],y+dir[1],grid);
        }
    }
}
