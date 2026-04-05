class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        int res = 1;

        for(int i=l-1;i>=0;i--){
            int justBigger=Integer.MAX_VALUE;
            int index = -1;
            for(int j=i;j<=l-1;j++){
                if(nums[j]>nums[i]){
                    if(nums[j]<justBigger){
                        justBigger=nums[j];
                        index = j;
                    }
                }
            }
            if(index==-1){
                dp[i]=1;
            }else{
                dp[i] = dp[index]+1;
            }
            res = Math.max(res,dp[i]);
        }

        return res;

    }
}
