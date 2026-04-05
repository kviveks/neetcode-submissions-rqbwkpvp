class Solution {
    private int m;
    private int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;


        for(int i = 0; i< m; i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
            if(board[i][n-1]=='O'){
                dfs(i,n-1,board);
            }
        }

        for(int j = 0; j<n; j++){
            if(board[0][j]=='O'){
                dfs(0,j,board);
            }
            if(board[m-1][j]=='O'){
                dfs(m-1,j,board);
            }
        }

        for(int i = 0 ;i<m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        } 

        for(int i = 0 ;i<m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        } 
    }

    public void dfs(int i, int j,char[][] board){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j]=='X' || board[i][j]=='#'){
            return;
        }

        board[i][j]='#';

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] dir : dirs){
            dfs(i+dir[0],j+dir[1],board);
        }
    }
}
