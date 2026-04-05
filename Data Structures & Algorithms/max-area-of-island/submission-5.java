class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }

        return res;
    }

    public int dfs(int[][] grid,int x,int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==0){
            return 0;
        }

        grid[x][y] = 0;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        int area = 0;
        for(int[] dir : dirs){
            area = area+dfs(grid,x+dir[0],y+dir[1]);
        }

        return 1+area;
    }
}
