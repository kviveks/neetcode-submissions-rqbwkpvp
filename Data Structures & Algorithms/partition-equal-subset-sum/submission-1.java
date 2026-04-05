class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If the sum is odd, we can't split it into two equal parts
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        
        // DP array to store if a subset sum is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Sum of 0 is always possible (empty subset)
        
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        return dp[target];
    }
}
