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
            int p1 = currentMax*nums[i];
            int p2 = currentMin*nums[i];
            currentMax = Math.max(nums[i],p1); //i=1, -3,12 => 12
            currentMax = Math.max(currentMax,p2); //i=1 , 12

            currentMin = Math.min(nums[i],p1);
            currentMin = Math.min(currentMin,p2);

            if(currentMax > globalMax){
                globalMax = currentMax;
            }


        }

        return globalMax;
        
    }
}
