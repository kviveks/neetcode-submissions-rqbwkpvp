class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return res;
    }

    public void dfs(String s,int p,List<String> curr){
        if(p==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=p;i<s.length();i++){
            String sub = s.substring(p,i+1);
            if(isPalindrome(sub)){
                curr.add(sub);
                dfs(s,i+1,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;

        while(l<=r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }

        return true;
    }
}
