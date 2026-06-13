class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0],globalMin = nums[0], currentMax = nums[0],currentMin =nums[0];
        int total = nums[0];

        for(int i=1;i<nums.length;i++){
            currentMax = Math.max(currentMax+nums[i],nums[i]);
            currentMin = Math.min(currentMin+nums[i],nums[i]);
            total+=nums[i];

            globalMax = Math.max(globalMax,currentMax);
            globalMin = Math.min(globalMin,currentMin);
        }

        if (globalMax < 0) {
            return globalMax;
        }


        return Math.max(globalMax,total-globalMin);
    }
}