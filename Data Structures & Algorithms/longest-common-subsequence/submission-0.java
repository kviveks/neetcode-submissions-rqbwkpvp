class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        int c = 0;
        for(int i = 0;i<n;i++){
            if(text1.charAt(0)==text2.charAt(i)){
                c = 1;
            }
            dp[0][i]=c;
        }

        c=0;
        for(int i = 0;i<m;i++){
            if(text2.charAt(0)==text1.charAt(i)){
                c = 1;
            }
            dp[i][0]=c;
        }


        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(text2.charAt(j)==text1.charAt(i)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m-1][n-1];


    }
}
