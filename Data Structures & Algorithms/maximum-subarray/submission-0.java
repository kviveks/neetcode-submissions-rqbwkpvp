class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length < 1){
            return 0;
        }

        int currMax = 0;
        int globalMax = Integer.MIN_VALUE;

        



        for(int i = 0; i<nums.length; i++){
            currMax = Math.max(currMax+nums[i],nums[i]);
            globalMax = Math.max(globalMax,currMax);
        }    

        return globalMax;
    }
}
