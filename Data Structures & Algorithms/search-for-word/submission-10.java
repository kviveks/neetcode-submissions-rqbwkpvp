class Solution {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,word,0,i,j,visited);
            }
        }

        return res;
    }


    public void dfs(char[][] board,String word,int p,int x,int y,boolean[][] visited){
        int m = board.length;
        int n = board[0].length;

        if(res==true||x<0||x>=m||y<0||y>=n || board[x][y]!=word.charAt(p) || visited[x][y]==true){
            return;
        }

        if(p==word.length()-1){
            res=true;
        }

        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        visited[x][y]=true;
        for(int[] dir : dirs){
            dfs(board,word,p+1,x+dir[0],y+dir[1],visited);
        }
        visited[x][y]=false;

    }
}
