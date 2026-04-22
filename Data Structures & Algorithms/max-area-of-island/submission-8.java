class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max = Math.max(max,dfs(i,j,grid));
                }
            }
        }

        return max;
    }

    public int dfs(int x,int y,int[][] grid){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0){
            return 0;
        }

        grid[x][y]=0;

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int area = 0;
        for(int[] dir : dirs){
            area = area + dfs(x+dir[0],y+dir[1],grid);
        }

        return 1+area;
    }
}
