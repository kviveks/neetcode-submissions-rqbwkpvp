class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    queue.addLast(new int[]{i,j});
                }
            }
        }

        
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0;i<size;i++){
                int[] cord = queue.removeFirst();
                int x = cord[0];
                int y = cord[1];

                for(int[] dir : dirs){
                    int x_ = x+dir[0];
                    int y_ = y+dir[1];

                    if(x_<0||x_>=m||y_<0||y_>=n){
                        continue;
                    }

                    if(grid[x_][y_]!=Integer.MAX_VALUE) continue;

                    grid[x_][y_]=grid[x][y]+1;
                    queue.addLast(new int[]{x_,y_});
                }
            }
        }
    }
}
