class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();


        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                    deque.addLast(new int[]{i,j});
            }
        }

        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i=1;i<=size;i++){
                int[] coord = deque.removeFirst();
                int x = coord[0];
                int y = coord[1];

                int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
                for(int[] dir : dirs){
                    int x_ = x+dir[0];
                    int y_ = y+dir[1];

                    if(x_<0||y_<0||x_>=grid.length||y_>=grid[0].length||grid[x_][y_]==-1)
                        continue;

                    if(grid[x_][y_] != Integer.MAX_VALUE)
                    continue;

                grid[x_][y_] = grid[x][y] + 1;
                deque.addLast(new int[]{x_,y_});
                }
            }
        }    
    }
}
