class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }
        return 0;
    }

    public int dfs(int x,int y,int[][] grid){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length){
            return 1;
        }


        if(grid[x][y]==0){
            return 1;
        }

        if(grid[x][y]==-1){
            return 0;
        }
        grid[x][y]=-1;
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int para = 0;
        for(int[] dir : dirs){
            para+=dfs(x+dir[0],y+dir[1],grid);
        }

        return para;
    }
}