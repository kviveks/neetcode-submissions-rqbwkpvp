class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = nums[0];
        int maxProduct = nums[0];

        int res = nums[0];


        for(int i=1;i<nums.length;i++){
            int currentMin = minProduct;
            int currentMax = maxProduct;

            maxProduct = Math.max(nums[i],Math.max(nums[i]*currentMin,nums[i]*currentMax));
            minProduct = Math.min(nums[i],Math.min(nums[i]*currentMin,nums[i]*currentMax)); 

            res = Math.max(res,maxProduct);
        }

        return res;
    }
}
