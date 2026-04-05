class Solution {
    public void islandsAndTreasure(int[][] grid) {
        bfs(grid);
    }

    public void bfs(int[][] grid){
        Deque<int[]> q = new ArrayDeque<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.addLast(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            int[] co = q.removeFirst();
            int x = co[0];
            int y = co[1];

            for(int[] dir:dirs){
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if(x_<0 || y_<0 || x_>=grid.length || y_>=grid[0].length)
                    continue;

                if(grid[x_][y_] != Integer.MAX_VALUE)
                    continue;

                grid[x_][y_] = grid[x][y] + 1;
                q.addLast(new int[]{x_,y_});
            }
        }
    }
}