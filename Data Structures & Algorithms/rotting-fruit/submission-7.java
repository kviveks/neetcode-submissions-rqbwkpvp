class Solution {
    int res = 2;
    public int orangesRotting(int[][] grid) {
        bfs(grid);

        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
                res = Math.max(res,grid[i][j]);
            }
        }
        return res == 2 ? 0 : res - 2;    
    }

    public void bfs(int[][] grid){
        Deque<int[]> rottenApple = new ArrayDeque<>();
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    rottenApple.addLast(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};


        while(!rottenApple.isEmpty()){
            int size = rottenApple.size();
            for(int i=1;i<=size;i++){
                int[] coordinates = rottenApple.removeFirst();
                int x = coordinates[0];
                int y = coordinates[1];
                for(int[] dir : dirs){
                    if(x+dir[0]<0||x+dir[0]>=grid.length||y+dir[1]<0||y+dir[1]>=grid[0].length){
                        continue;
                    }
                    if(grid[x+dir[0]][y+dir[1]]==1){
                        grid[x+dir[0]][y+dir[1]]=1+grid[x][y];
                        rottenApple.addLast(new int[]{x+dir[0],y+dir[1]});
                    }
                }
            }
        }    
    }
}
