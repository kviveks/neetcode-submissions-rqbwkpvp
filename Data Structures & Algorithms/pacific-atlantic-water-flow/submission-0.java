class Solution {
    private int m;
    private int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        int[][] pac = new int[m][n];
        int[][] alt = new int[m][n];


        for(int i = 0;i<m;i++){
            pac[i][0]=1;
            alt[i][n-1]=1;
        }

        for(int j = 0; j<n;j++){
            pac[0][j]=1;
            alt[m-1][j]=1;
        }


        for(int i =1;i<m;i++){
            for(int j = 1; j< n;j++){
                if((heights[i][j] >= heights [i][j-1] && pac[i][j-1]==1) || (heights[i][j] >= heights [i-1][j] && pac[i-1][j]==1)){
                    pac[i][j]=1;
                }
            }
        }


        for(int i = m-2; i>=0;i--){
            for(int j = n-2;j >=0 ;j--){
                if((heights[i][j] >= heights [i+1][j] && alt[i+1][j]==1) || (heights[i][j] >= heights [i][j+1] && alt[i][j+1]==1)){
                    alt[i][j]=1;
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i< m;i++){
            for(int j = 0; j< n;j++){
                if(pac[i][j]==1 && alt[i][j]==1){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;   
    }
}
