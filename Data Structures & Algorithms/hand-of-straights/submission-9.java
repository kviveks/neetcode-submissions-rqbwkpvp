class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0)
            return false;

        int maxNumber = 0;
        for(int n : hand){
            maxNumber = Math.max(n, maxNumber);
        }

        int[] dp = new int[maxNumber + 1];

        for(int n : hand){
            dp[n]++;
        }

        int i = 0;

        while(i <= maxNumber){

            if(dp[i] == 0){
                i++;
                continue;
            }

            // Try to build group starting at i
            for(int j = 0; j < groupSize; j++){

                if(i + j > maxNumber || dp[i + j] == 0){
                    return false;
                }

                dp[i + j]--;
            }
        }

        return true;
    }
}
