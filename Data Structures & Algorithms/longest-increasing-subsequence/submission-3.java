

class Solution {
    public int lengthOfLIS(int[] nums) {

        int l = nums.length;

        if(l==0){
            return 0;
        }

        if(l==1){
            return 1;
        }
        int dp[] = new int[l];
        int result = Integer.MIN_VALUE;
        dp[l-1]=1;
        int currentMax;


        for(int i = l-2;i>=0;i--){
            currentMax = 1;
            for(int j = i+1; j<l;j++){
                if(nums[i]<nums[j]){
                    currentMax= Math.max(currentMax,1+dp[j]);
                }
            }
            dp[i]=currentMax;
            result = Math.max(result,currentMax);
        }

        return result;
    }
}

