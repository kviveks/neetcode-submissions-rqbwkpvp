class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0){
            return false;
        }

        int maxNum = 0;
        for(int n : hand){
            maxNum = Math.max(n,maxNum);
        }

        int[] dp = new int[maxNum+1];

        for(int n : hand){
            dp[n]++;
        }

        int i = 0;
        while(i<=maxNum){

            if(dp[i]==0){
                i++;
                continue;
            }

            for(int j=0;j<groupSize;j++){
                if(i+j>maxNum || dp[i+j]==0){
                    return false;
                }

                dp[i+j]--;
            }
        }

        return true;
    }
}
