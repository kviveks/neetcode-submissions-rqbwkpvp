class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        int freshFruit = 0;
        int time = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshFruit++;
                }else if(grid[i][j]==2){
                    deque.add(new int[]{i,j});
                }
            }
        }

        if (freshFruit == 0) return 0;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i=0;i<size;i++){
                int[] cord = deque.removeLast();
                int x = cord[0];
                int y = cord[1];

                for(int[] dir : dirs){
                    int x_ = x+dir[0];
                    int y_ = y+dir[1];

                    if(x_<0||y_<0||x_>=grid.length||y_>=grid[0].length){
                        continue;
                    }

                    if(grid[x_][y_]!=1){
                        continue;
                    }

                    grid[x_][y_]=2;
                    freshFruit--;
                    deque.add(new int[]{x_,y_});
                }
            }
            time++;
        }

        if(freshFruit==0){
            return time;
        }else{
            return -1;
        }
    }
}
