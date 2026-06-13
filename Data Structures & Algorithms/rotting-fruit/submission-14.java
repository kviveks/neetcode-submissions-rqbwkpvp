class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m=grid.length;
        int n=grid[0].length;
        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.addLast(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0){
            return 0;
        }

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int[] coord = queue.removeFirst();
                int x = coord[0];
                int y = coord[1];

                for(int[] dir : dirs){
                    int x_ = x+dir[0];
                    int y_ = y+dir[1];

                    if(x_<0||x_>=m||y_<0||y_>=n){
                        continue;
                    }

                    if(grid[x_][y_]!=1){
                        continue;
                    }

                    grid[x_][y_]=grid[x][y]+1;
                    
                    fresh--;

                    queue.addLast(new int[]{x_,y_});
                }
            }
            time++;
        }

        if(fresh!=0){
            return -1;
        }

        return time;
    }
}
