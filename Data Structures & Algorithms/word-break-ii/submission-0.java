class Solution {
    Set<String> word = new HashSet<>();
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String x : wordDict){
            word.add(x);
        }


        dfs(s,0,new StringBuilder());
        return res;
    }

    public void dfs(String s,int p,StringBuilder sb){
        if(p==s.length()){
            res.add(new String(sb.toString().trim()));
            return;
        }


        for(int i=p;i<s.length();i++){
            String curr = s.substring(p,i+1);
            if(word.contains(curr)){
                int len = sb.length();
                sb.append(curr).append(" ");
                dfs(s,i+1,sb);
                sb.setLength(len);
            }
        }
    }
}