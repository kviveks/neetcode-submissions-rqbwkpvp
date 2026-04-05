class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        dp[nums.length-1]=1;

        for(int i=nums.length-2;i>=0;i--){
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                    res = Math.max(dp[i],res);
                }
            }
        }

        return res;
    }
}
