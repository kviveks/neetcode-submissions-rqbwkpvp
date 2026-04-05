class Solution {
    private int m;
    private int n;
    public void solve(char[][] board) {
        m= board.length;
        n=board[0].length;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(board[i][j]=='O'){
                    if(dfs(i,j,board,dirs[0]) && dfs(i,j,board,dirs[1]) && dfs(i,j,board,dirs[2]) && dfs(i,j,board,dirs[3])){
                        board[i][j] = 'X';
                    }
                }
            }
        }
        
    }

    public boolean dfs(int i, int j,char[][] board,int[] dir){

        if(i<0 || i >= m || j < 0 || j>=n){
            return false;
        }
        if(board[i][j]=='X'){
            return true;
        }

        return dfs(i+dir[0],j+dir[1],board, dir);


    }



}
