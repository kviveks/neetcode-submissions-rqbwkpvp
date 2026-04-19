class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] rows : board){
            Arrays.fill(rows,'.');
        }

        dfs(0,n,board);
        return res;
    }

    public void dfs(int r,int n,char[][] board){

        if(r==n){
            List<String> copy = new ArrayList<>();
            for(char[] row : board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c=0;c<n;c++){
            if(col.contains(c) || posDiag.contains(c+r) || negDiag.contains(c-r)){
                continue;
            }

            col.add(c);
            posDiag.add(c+r);
            negDiag.add(c-r);
            board[r][c]='Q';

            dfs(r+1,n,board);

            col.remove(c);
            posDiag.remove(c+r);
            negDiag.remove(c-r);
            board[r][c]='.';

        }
    }
}
