class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,new StringBuilder(),0,0);
        return res;    
    }

    public void dfs(int n,StringBuilder sb,int open,int close){
        if(close>open){
            return;
        }

        if(open==close && open==n){
            res.add(new String(sb));
        }

        if(open<n){
            sb.append('(');
            dfs(n,sb,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }

        sb.append(")");
        dfs(n,sb,open,close+1);
        sb.deleteCharAt(sb.length()-1);
    }
}
