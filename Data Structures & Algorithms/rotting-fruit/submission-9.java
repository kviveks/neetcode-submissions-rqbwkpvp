class Solution {
    public int orangesRotting(int[][] grid) {

        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.addLast(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;

        int time = 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty() && fresh>0){

            int size = queue.size();
            time++;

            for(int i=0;i<size;i++){
                int[] cur = queue.removeFirst();

                for(int[] d:dirs){
                    int r = cur[0]+d[0];
                    int c = cur[1]+d[1];

                    if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=1){
                        continue;
                    }

                    grid[r][c] = 2;
                    fresh--;
                    queue.addLast(new int[]{r,c});
                }
            }
        }

        return fresh==0 ? time : -1;
    }
}