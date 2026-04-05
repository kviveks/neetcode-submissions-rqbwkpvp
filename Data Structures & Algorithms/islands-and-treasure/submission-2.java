class Solution {
    public void islandsAndTreasure(int[][] grid) {
        bfs(grid);      
    }

    public void bfs(int[][] grid){

        Deque<int[]> treasureGrid = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    treasureGrid.add(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!treasureGrid.isEmpty()){
            int size = treasureGrid.size();
            for(int i=1;i<=size;i++){
                int[] cordinates = treasureGrid.removeFirst();
                int x = cordinates[0];
                int y = cordinates[1];
                for(int[] dir : dirs){
                    if(x+dir[0]<0||x+dir[0]>=grid.length||y+dir[1]<0||y+dir[1]>=grid[0].length){
                        continue;
                    }
                    if(grid[x+dir[0]][y+dir[1]]==-1 || grid[x+dir[0]][y+dir[1]]<grid[cordinates[0]][cordinates[1]]+1){
                        continue;
                    }
                    grid[x+dir[0]][y+dir[1]]=grid[cordinates[0]][cordinates[1]]+1;
                    treasureGrid.addLast(new int[]{x+dir[0],y+dir[1]});
                }

            }
        }
    }
}
