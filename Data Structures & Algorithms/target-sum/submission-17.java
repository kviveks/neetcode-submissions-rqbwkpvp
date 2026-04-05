class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int l = nums.length;
        int sum = 0;
        for (int n : nums) sum += n;

        if (Math.abs(target) > sum) return 0;

        int[][] dp = new int[l][2 * sum + 1];

        
        dp[0][sum + nums[0]]+= 1;
        dp[0][sum - nums[0]]+= 1;

        for (int i = 1; i < l; i++) {
            int num = nums[i];
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (dp[i - 1][j] != 0) {
                    dp[i][j + num] += dp[i - 1][j];
                    dp[i][j - num] += dp[i - 1][j];
                }
            }
        }

        return dp[l - 1][sum + target];
    }
}
