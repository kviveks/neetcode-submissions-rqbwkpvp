class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int l = nums.length;
        int sum = 0;
        for(int i = 0;i<l;i++){
            sum = sum+nums[i];
        }

        int[] dp = new int[2*sum+1];

        for(int i = 0;i<l; i++){
            dp[sum-nums[i]]=dp[sum-nums[i]]+1;
        }

        return dp[sum-target];


        
    }
}
