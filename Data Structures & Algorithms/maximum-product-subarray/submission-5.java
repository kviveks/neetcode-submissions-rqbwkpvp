class Solution {
    int res;
    public int maxProduct(int[] nums) {

        int[] maxP = new int[nums.length];
        int[] minP = new int[nums.length];

        maxP[0] = nums[0];
        minP[0] = nums[0];
        res = nums[0];


        for(int i=1;i<nums.length;i++){
            int max = Math.max(maxP[i-1]*nums[i],minP[i-1]*nums[i]);
            max = Math.max(max,nums[i]);
            maxP[i] = max;

            int min = Math.min(maxP[i-1]*nums[i],minP[i-1]*nums[i]);
            min = Math.min(min,nums[i]);
            minP[i] = min;

            res = Math.max(max,res);
        }

        return res;
        
    }
}
