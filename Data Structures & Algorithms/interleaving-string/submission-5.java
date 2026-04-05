class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (s1.length() + s2.length() != s3.length()) return false;

        int[][] dp = new int[l1+1][l2+1];
        dp[0][0]=1;
        int i=0;
        int j=0;
        for(j=1;j<l2+1;j++){
            if(dp[i][j-1]==1 && s2.charAt(j-1)==s3.charAt(i+j-1)){
                dp[i][j]=1;
            }
        }
        j=0;
        for(i=1;i<l1+1;i++){
            if(dp[i-1][j]==1 && s1.charAt(i-1)==s3.charAt(i+j-1)){
                dp[i][j]=1;
            }
        }


        for(i=1;i<l1+1;i++){
            for(j=1;j<l2+1;j++){
                if(dp[i-1][j]==1 && s1.charAt(i-1)==s3.charAt(i+j-1) || 
                dp[i][j-1]==1 && s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j]=1;
                }
            }
        }

        return dp[l1][l2]==1?true:false;
    }
}
