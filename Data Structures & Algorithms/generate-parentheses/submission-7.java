class Solution {
    List<String> res  = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,0,0,new StringBuilder());
        return res;
    }


    public void dfs(int n,int open,int close,StringBuilder sb){
        if(close>open || open>n || close>n){
            return;
        }

        if(close==open && open==n){
            res.add(new String(sb));
            return;
        }


        sb.append('(');
        dfs(n,open+1,close,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        dfs(n,open,close+1,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
