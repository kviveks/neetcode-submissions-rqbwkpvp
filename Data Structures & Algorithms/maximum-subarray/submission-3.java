class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int currentMax = nums[0];

        for(int i=1;i<nums.length;i++){
            currentMax = Math.max(currentMax+nums[i],nums[i]);
            ans = Math.max(ans,currentMax);
        }

        return ans;
    }
}
