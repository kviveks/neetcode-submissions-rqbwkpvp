class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        int l = s.length();
        for(String word : wordDict){
            wordSet.add(word);
        }

        boolean[] dp = new boolean[l+1];
        dp[l]=true;


        for(int i=l-1;i>=0;i--){
            for(int j=i;j<=l;j++){
                if(dp[j]==true){
                    if(wordSet.contains(s.substring(i,j))){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }


        return dp[0];
    }
}
