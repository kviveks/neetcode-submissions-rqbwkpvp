class Solution {
    int count = 0;
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    public int totalNQueens(int n) {

        dfs(0,n);
        return count;
    }

    public void dfs(int r,int n){

        if(r==n){
            count++;
        }

        for(int c=0;c<n;c++){
            if(col.contains(c) || posDiag.contains(c+r) || negDiag.contains(c-r)){
                continue;
            }

            col.add(c);
            posDiag.add(c+r);
            negDiag.add(c-r);

            dfs(r+1,n);

            col.remove(c);
            posDiag.remove(c+r);
            negDiag.remove(c-r);

        }
    }
}