class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int m = nums.length+1;
       int sum =0;
       for(int num : nums){
        sum+=num;
       }

       if (Math.abs(target) > sum) return 0;

       int n = sum*2+1;


       int[][] dp = new int[m][n];

       dp[0][sum] = 1;


       for(int i=1;i<m;i++){
        int num = nums[i-1];
        for(int j=0;j<n;j++){
            if(dp[i-1][j]!=0){
                dp[i][j+num]+=dp[i-1][j];
                dp[i][j-num]+=dp[i-1][j];
            }
        }
       }

       return dp[m-1][sum+target]; 
    }
}
