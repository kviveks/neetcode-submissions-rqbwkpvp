class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }

            if(board[i][n-1]=='O'){
                dfs(i,n-1,board);
            }
        }  

        for(int i = 0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(0,i,board);
            }

            if(board[m-1][i]=='O'){
                dfs(m-1,i,board);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }   
    }


    public void dfs(int x,int y,char[][] board){
        board[x][y]='#';

        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};

        for(int[] dir : dirs){
            int x_ = x+dir[0];
            int y_ = y+dir[1];

            if(x_>=0 && x_<board.length && y_>=0 && y_<board[0].length && board[x_][y_]=='O'){
                dfs(x_,y_,board);
            }
        }
    }
}
