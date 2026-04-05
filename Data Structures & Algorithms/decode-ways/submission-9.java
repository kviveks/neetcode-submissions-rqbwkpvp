class Solution {
    public int numDecodings(String s) {

        if(s.charAt(0)=='0'){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        Set<String> valid = new HashSet<>();
        for(int i=1;i<=26;i++){
            valid.add(String.valueOf(i));
        }

        if(valid.contains(s.substring(0,1))){
            dp[0]=1;
        }

        if(valid.contains(s.substring(1,2))){
            dp[1]=dp[0];
        }

        if(valid.contains(s.substring(0,2))){
            dp[1]=dp[1]+1;
        }

        if(dp[1]==0){
            return 0;
        }

        for(int i=2;i<n;i++){
            if(valid.contains(s.substring(i,i+1))){
                dp[i] = dp[i-1];
            }
            if(valid.contains(s.substring(i-1,i+1))){
                dp[i] = dp[i]+dp[i-2];
            }
        }

        return dp[n-1];


    }
}
