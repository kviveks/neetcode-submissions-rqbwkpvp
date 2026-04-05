class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int maxNumber = 0;

        if(hand.length % groupSize != 0)
            return false;

        for(int n : hand){
            maxNumber = Math.max(n,maxNumber);
        }


        int[] dp = new int[maxNumber+1];

        for(int n: hand){
            dp[n]++;
        }

        int i=0;
        while(i<=maxNumber){
            if(dp[i]!=0){
                for(int j=0;j<groupSize;j++){
                    if(dp[i+j]<1 && i+j<=maxNumber){
                        return false;
                    }
                    dp[i+j]--;
                }
            }else{
                i++;
            }
        }
        
        return true;    
    }
}
