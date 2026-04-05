class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        int open = 0, close = 0;
        int i = 0;
        backtrack(res,0,0,n,stack);

        return res;

        
    }

    public void backtrack(List<String> res,int open, int close, int n, StringBuilder stack){

        if(open==close && open==n){
            res.add(stack.toString());
            return;
        }

        if(open < n){
            stack.append('(');
            backtrack(res,open+1,close,n,stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if(close < open){
            stack.append(')');
            backtrack(res,open,close+1,n,stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
