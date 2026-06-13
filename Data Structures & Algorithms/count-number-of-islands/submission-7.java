class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }

        return count;
    }

    public void dfs(int x,int y,char[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(x<0||x>=m||y<0||y>=n|| grid[x][y]=='0')
            return;

        grid[x][y]='0';

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};


        for(int[] dir : dirs){
            dfs(x+dir[0],y+dir[1],grid);
        }
    }
}
