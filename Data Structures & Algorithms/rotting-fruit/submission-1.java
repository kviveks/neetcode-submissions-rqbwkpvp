class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int time = 0;


        for(int i = 0; i< m ;i++){
            for(int j = 0; j< n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};


        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];

                if(r < 0 || r >= m || c < 0 || c>= n || grid[r][c]!=1){
                    continue;
                }

                q.add(new int[]{r,c});
                grid[r][c] = grid[row][col]+1;
                time = Math.max(grid[r][c],time);
            }
        }

        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1;
                }
            }
        }
        return time == 0 ? 0 : time - 2;    
    }
}
