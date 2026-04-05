class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;

        for(int i=nums.length-2;i>=0;i--){
            for(int j=i;j<=nums.length-1;j++){
                if(nums[j]>nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    
                }
            }
            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
