class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int time = 0;
        int freshFruit = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    freshFruit++;
                if(grid[i][j]==2)
                    queue.addLast(new int[]{i,j});
            }
        }

        if(freshFruit==0){
            return 0;
        }


        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty() && freshFruit > 0){
            int size = queue.size();

            for(int i=1;i<=size;i++){
                int[] coord = queue.removeFirst();
                int x = coord[0];
                int y = coord[1];
                for(int[] dir : dirs){
                    int x_ = x+dir[0];
                    int y_ = y+dir[1];
                    
                    if(x_<0||x_>=grid.length||y_<0||y_>=grid[0].length)
                        continue;

                    if(grid[x_][y_]!=1){
                        continue;
                    }

                    grid[x_][y_]=2;
                    queue.addLast(new int[]{x_,y_});
                    freshFruit--;
                }
            }
            time++;
        }

        return freshFruit==0?time:-1;
    }
}
