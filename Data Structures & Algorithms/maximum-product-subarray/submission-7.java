class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for(int i=1;i<nums.length;i++){
            dpMax[i]=Math.max(nums[i],Math.max(nums[i]*dpMax[i-1],nums[i]*dpMin[i-1]));
            dpMin[i]=Math.min(nums[i],Math.min(nums[i]*dpMax[i-1],nums[i]*dpMin[i-1]));
            res = Math.max(res,dpMax[i]);
        }

        return res;
    }
}
