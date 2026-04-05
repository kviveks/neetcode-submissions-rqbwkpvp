class Solution {
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                found = dfs(board,word,i,j,0,visited);
                if(found){
                    return true;
                }
            }
        }
        return false;    
    }

    public boolean dfs(char[][] board, String word,int x,int y,int p,boolean[][] visited){
        if(p==word.length()){
            return true;
        }

        if(x<0 || x >= board.length || y<0 || y>=board[0].length)
            return false;

        if(board[x][y]!=word.charAt(p))
            return false;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        boolean res = false;
        visited[x][y]=true;
        for(int dir[] : dirs){
            res = res || dfs(board,word,x+dir[0],y+dir[1],p+1,visited);   
        }
        visited[x][y]=false;
        return res;
    }
}
