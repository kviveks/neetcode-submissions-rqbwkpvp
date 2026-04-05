class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }

        int globalMax = Integer.MIN_VALUE, currentMax = nums[0], currentMin = nums[0];

        for(int i = 1; i<nums.length; i++){

            currentMax = Math.max(nums[i],currentMax*nums[i]);
            currentMax = Math.max(currentMax,currentMin*nums[i]);

            currentMin = Math.min(nums[i],currentMin*nums[i]);
            currentMin = Math.min(currentMin,currentMax*nums[i]);

            if(currentMax > globalMax){
                globalMax = currentMax;
            }


        }

        return globalMax;
        
    }
}
