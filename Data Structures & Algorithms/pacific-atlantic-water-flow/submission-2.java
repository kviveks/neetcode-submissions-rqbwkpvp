class Solution {
    private int m;
    private int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        int[][] pac = new int[m][n];
        int[][] alt = new int[m][n];


        for(int j = 0;j < n;j ++){
            dfs(0,j,pac,0,heights);
            dfs(m-1,j,alt,0,heights);
        }

        for(int i = 0; i< m;i++){
            dfs(i,0,pac,0,heights);
            dfs(i,n-1,alt,0,heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i< m;i++){
            for(int j = 0;j < n ;j++){
                if(pac[i][j]==1 && alt[i][j]==1){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;    
    }


    public void dfs(int i ,int j,int[][] d,int prevHeight,int[][] heights){
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        if(i < 0 || i>=m || j <0 || j>=n || heights[i][j] < prevHeight || d[i][j]==1){
            return;
        }
        d[i][j] = 1;
        for(int[] dir : dirs){
            dfs(i+dir[0],j+dir[1],d,heights[i][j],heights);
        }
    }
}
