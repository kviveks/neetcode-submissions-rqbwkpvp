class Solution {
    public boolean isMatch(String s, String p) {
        int l1=p.length();
        int l2=s.length();

        boolean[][] dp = new boolean[l1+1][l2+1];

        dp[0][0]=true;


        for(int i=1;i<=l1;i++){
            if(p.charAt(i-1)=='*'){
                dp[i][0]=dp[i-1][0];
            }
        }



        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s.charAt(j-1)==p.charAt(i-1)||p.charAt(i-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(i-1)=='*'){
                    for(int k=j;k>=0;k--){
                        if(dp[i-1][k]==true){
                            dp[i][j]=true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[l1][l2];    
    }
}
