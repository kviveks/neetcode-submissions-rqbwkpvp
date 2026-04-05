// n e e t c o d e s
// 0 1 2 3 4 5 6 7 8 9

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int l = s.length();
        int[] dp = new int[l+1];

        dp[l] = 1;


        for(int i = l-1;i>=0;i--){
            String subs = s.substring(i);
            for(int j = 0;j<wordDict.size();j++){

                if(subs.startsWith(wordDict.get(j)) && i+wordDict.get(j).length()<=l && dp[i+wordDict.get(j).length()]==1){
                    dp[i]=1;
                    break;
                }
            }
        }

        if(dp[0]==1){
            return true;
        }
        return false;

        
    }
}
