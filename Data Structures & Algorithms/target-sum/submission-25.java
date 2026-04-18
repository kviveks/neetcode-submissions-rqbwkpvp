class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }

        if (Math.abs(target) > sum) return 0;

        int[][] dp = new int[nums.length][2*sum+1];
        dp[0][nums[0]+sum] += 1;
        dp[0][-nums[0]+sum] += 1;


        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=2*sum;j++){
                if(dp[i-1][j]!=0){
                    dp[i][j-nums[i]]=dp[i-1][j]+dp[i][j-nums[i]];
                    dp[i][j+nums[i]]=dp[i-1][j]+dp[i][j+nums[i]];
                }
            }
        }

        return dp[nums.length-1][target+sum];

        
    }
}
