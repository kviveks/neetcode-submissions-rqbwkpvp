class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        int[] dp = new int[l+1];
        dp[l]=1;
        for(int i=l-1;i>=0;i--){
            for(String word : wordDict){
                int lw = word.length();
                if(lw+i>l){
                    continue;
                }
                String sub = s.substring(i,i+lw);
                if(sub.equals(word) && dp[i+lw]==1){
                    dp[i]=1;
                }
            }
        }

        return dp[0]==1?true:false;


    }
}
