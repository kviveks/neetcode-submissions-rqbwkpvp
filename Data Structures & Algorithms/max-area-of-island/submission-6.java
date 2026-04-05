class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    area = Math.max(area,calculateArea(i,j,grid));
            }
        }

        return area;    
    }

    public int calculateArea(int x,int y,int[][] grid){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==0){
            return 0;
        }

        grid[x][y]=0;
        int area = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] dir : dirs){
            area = area + calculateArea(x+dir[0],y+dir[1],grid);
        }

        return area+1;
    }



}
