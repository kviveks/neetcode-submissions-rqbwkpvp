class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if(l1+l2!=l3) return false;
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0]=true;
        int j,i;
        j=0;
        i=1;
        for(i=1;i<=l1;i++){
            if(s3.charAt(i+j-1)==s1.charAt(i-1)&& dp[i-1][j]){
                dp[i][j]=true;
            }
        }
        i=0;
        for(j=1;j<=l2;j++){
            if(s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]){
                dp[i][j]=true;
            }
        }

        for(i=1;i<=l1;i++){
            for(j=1;j<=l2;j++){
                if(s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j] || s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]){
                    dp[i][j]=true;
                }
            }
        } 


        return dp[l1][l2];  
    }
}
