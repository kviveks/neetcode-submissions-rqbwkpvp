class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n,new StringBuilder());
        return res;    
    }

    public void dfs(int open,int close,int n,StringBuilder sb){
        if(close>open){
            return;
        }

        if(open==close && open==n){
            res.add(new String(sb.toString()));
            return;
        }

        if(open < n) {
            sb.append("(");
            dfs(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append(")");
        dfs(open,close+1,n,sb);
        sb.deleteCharAt(sb.length()-1);
        
    }
}
