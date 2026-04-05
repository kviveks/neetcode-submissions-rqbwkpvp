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


        for(int i=0;i<=maxNumber;i++){
            if(dp[i]!=0){
                int count=0;
                for(int j=0;j<groupSize && i+j<=maxNumber;j++){
                    if(dp[i+j]<1){
                        return false;
                    }
                    dp[i+j]--;
                    count++;
                }
                if(count!=groupSize)
                    return false;
            }
        }

        return true;    
    }
}
