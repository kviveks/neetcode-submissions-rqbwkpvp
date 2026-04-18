class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int res = 1;
        int[] dp = new int[l];
        Arrays.fill(dp,1);
        for(int i=l-2;i>=0;i--){
            for(int j=i;j<l;j++){
                if(nums[j]>nums[i]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                    res=Math.max(res,dp[i]);
                }
            }
        }

        return res;
    }
}
