class Solution {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,word,0);
                if(res==true){
                    return true;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] board,int x,int y,String word,int p){
        if(x<0 || y < 0 || x>=board.length || y>=board[0].length){
            return;
        }

        if(word.charAt(p)!=board[x][y]){
            return;
        }

        if(p == word.length() - 1){
    res = true;
    return;
}

        int[][] dirs ={{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] dir : dirs){
            dfs(board,x+dir[0],y+dir[1],word,p+1);
        }

    }
}
