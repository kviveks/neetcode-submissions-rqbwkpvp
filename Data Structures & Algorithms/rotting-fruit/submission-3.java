class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<int[]>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.addLast(new int[]{i,j});
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;

        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] pos = queue.removeFirst();
                int x = pos[0];
                int y = pos[1];

                for(int[] dir : dirs){
                    if(x+dir[0]>=0 && x+dir[0]<grid.length && y+dir[1]>=0 && y+dir[1]<grid[0].length && grid[x+dir[0]][y+dir[1]]==1){
                        grid[x+dir[0]][y+dir[1]]=2;
                        queue.addLast(new int[]{x+dir[0],y+dir[1]});
                    }
                }
                
            }
        }

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        } 

        return count-1;   
    }
}
