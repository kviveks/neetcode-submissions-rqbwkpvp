class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];


        for(int i = 0;i<m;i++){
            dfs(i,0,pac,m,n,heights);
            dfs(i,n-1,atl,m,n,heights);
        }

        for(int j=0;j<n;j++){
            dfs(0,j,pac,m,n,heights);
            dfs(m-1,j,atl,m,n,heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j]==1 && atl[i][j]==1){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;

    }

    public void dfs(int x,int y,int[][] ocean,int m,int n,int[][] heights){
        if(ocean[x][y]==1){
            return;
        }
        ocean[x][y]=1;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] dir : dirs){
            int x_ = dir[0];
            int y_ = dir[1];

            if(x+x_>=0 && x+x_ <m && y+y_ >=0 && y+y_ < n && ocean[x+x_][y+y_]!=1){
                if(heights[x+x_][y+y_]>=heights[x][y]){
                    dfs(x+x_,y+y_,ocean,m,n,heights);
                }   
            }
        }
    }
}
