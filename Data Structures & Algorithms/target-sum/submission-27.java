class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }

        if(Math.abs(target)>sum) return 0;
        int m = nums.length;
        int[][] dp = new int[m+1][2*sum+1];
        dp[0][0+sum]=1;


        for(int i=1;i<m+1;i++){
            for(int j=0;j<=2*sum;j++){
                if(dp[i-1][j]!=0){
                    dp[i][j+nums[i-1]]+=dp[i-1][j];
                    dp[i][j-nums[i-1]]+=dp[i-1][j];
                }
            }
        }

        return dp[m][sum+target];
    }
}
