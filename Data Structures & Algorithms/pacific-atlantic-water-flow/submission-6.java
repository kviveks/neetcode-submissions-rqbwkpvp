class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,pac,heights,0);
            dfs(i,n-1,atl,heights,0);
        }

        for(int j=0;j<n;j++){
            dfs(0,j,pac,heights,0);
            dfs(m-1,j,atl,heights,0);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pac[i][j] == 1 && atl[i][j] == 1) {
                    res.add(Arrays.asList(i, j)); 
                }
            }
        }

        return res;
        
    }

    public void dfs(int x,int y,int[][] ocean,int[][] heights,int prevHeight){
        if(x<0||y<0||x>=heights.length||y>=heights[0].length||ocean[x][y]==1||heights[x][y]<prevHeight){
            return;
        }

        ocean[x][y]=1;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};


        for(int[] dir : dirs){
            dfs(x+dir[0],y+dir[1],ocean,heights,heights[x][y]);
        }
    }
}
