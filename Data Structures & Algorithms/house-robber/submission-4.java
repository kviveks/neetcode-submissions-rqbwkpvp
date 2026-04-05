
//0 1 2 3 4 5

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = nums[1];

        int globalMax = Math.max(dp[0],dp[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = dp[i-2]+nums[i];
            globalMax=Math.max(globalMax,dp[i]);
        }

        return globalMax;    
    }
}
