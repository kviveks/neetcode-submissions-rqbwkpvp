class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int maxNumber = 0;
        for(int n : hand){
            maxNumber = Math.max(n,maxNumber);
        }


        int[] dp = new int[maxNumber+1];

        for(int n: hand){
            dp[n]++;
        }


        for(int i=0;i<=maxNumber;i++){
            if(dp[i]!=0){
                for(int j=0;j<groupSize;j++){
                    if(dp[i+j]<1){
                        return false;
                    }
                    dp[i+j]--;
                }
            }
        }

        return true;    
    }
}
