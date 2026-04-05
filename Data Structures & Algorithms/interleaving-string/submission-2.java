/*
0 1 2 3 4 5
a a x a b y
    0  1 2 3
     0 a a b 
0   0
1   a
2   x
3   y
*/



class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1= s1.length();
        int l2= s2.length();
        int[][] dp = new int[l1+1][l2+1];

        dp[0][0] = 1;

        int i = 0;
        for(int j = 1;j<l1+1;j++){
            if(dp[i][j-1]==1 && s3.charAt(i+j-1)==s1.charAt(j-1)){
                dp[i][j]=1;
            }
        }

        int j = 0;
        for(i = 1;i<l2+1;i++){
            if(dp[i-1][j]==1 && s3.charAt(i+j-1)==s2.charAt(i-1)){
                dp[i][j]=1;
            }
        }


        for(i=1;i<l1+1;i++){
            for(j=1;j<l2+1;j++){
                if(dp[i][j-1]==1 && s3.charAt(i+j-1)==s1.charAt(j-1) || dp[i-1][j]==1 && s3.charAt(i+j-1)==s2.charAt(i-1)){
                    dp[i][j]=1;
                }
            }
        }

        if(dp[l1][l2]==1)
            return true;
        else
            return false;

    }
}
