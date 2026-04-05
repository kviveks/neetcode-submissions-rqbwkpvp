class Solution {
    public int numDecodings(String s) {

        HashSet<String> hashset = new HashSet<String>();
        for(int i = 1;i<=26;i++){
            hashset.add(String.valueOf(i));
        }
        int l = s.length();
        int[] dp = new int[l];


        
        if(l==0){
            return 0;
        }

        if(hashset.contains(String.valueOf(s.charAt(0)))){
            dp[0]=1;
        }else{
            return 0;
        }

        if(l==1){
            return dp[0];
        }

        if(hashset.contains(String.valueOf(s.charAt(1)))){
            dp[1]=1;
        }

        if(hashset.contains(s.substring(0,2))){
            dp[1]=dp[1];
        }

        if(dp[1]==0){
            return 0;
        }



        for(int i=1;i<=l-2;i++){

        if(hashset.contains(String.valueOf(s.charAt(i+1)))){
            dp[i+1]=dp[i+1]+dp[i];
        }

        if(hashset.contains(s.substring(i,i+2))){
            dp[i+1]=dp[i+1]+dp[i-1];
        }
        if(dp[i+1]==0){
            return 0;
        }
        }

        return dp[l-1];
    }
}
