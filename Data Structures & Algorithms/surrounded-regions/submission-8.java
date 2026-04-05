class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            dfs(i,0,board);
            dfs(i,n-1,board);
        }

        for(int j=0;j<n;j++){
            dfs(0,j,board);
            dfs(m-1,j,board);
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


    public void dfs(int x,int y, char[][] board){
        if(x<0||y<0||x>=board.length||y>=board[0].length||board[x][y]!='O'){
            return;
        }

        board[x][y]='#';

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};


        for(int[] dir : dirs){
            dfs(x+dir[0],y+dir[1],board);
        }
    }
}
