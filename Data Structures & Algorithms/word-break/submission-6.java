class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp = new boolean[n+1];
        dp[n]=true;

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<=n;j++){
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
