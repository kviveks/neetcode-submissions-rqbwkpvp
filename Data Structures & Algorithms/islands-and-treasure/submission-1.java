class Solution {
    public void islandsAndTreasure(int[][] grid) {
    Deque<int[]> q = new ArrayDeque<>();

    for(int i =0;i<grid.length;i++){
        for(int j =0;j<grid[0].length;j++){
            if(grid[i][j]==0){
                q.addLast(new int[]{i,j});
            }
        }
    }

    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

    while(q.size()!=0){
        for(int i=0;i<q.size();i++){
            int[] curr = q.removeFirst();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir : dirs){
                int r = x+dir[0];
                int c = y+dir[1];

                if(r>=grid.length||r<0||c>=grid[0].length||c<0||grid[r][c]!=Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[]{r,c});
                grid[r][c]=grid[x][y]+1;
            }
        }    
    }    
    }
}
