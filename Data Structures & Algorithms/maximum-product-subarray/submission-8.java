class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpmax = new int[n];
        int[] dpmin = new int[n];

        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int res = nums[0];


        for(int i=1;i<n;i++){
            dpmax[i]=Math.max(nums[i],Math.max(dpmax[i-1]*nums[i],dpmin[i-1]*nums[i]));
            dpmin[i]=Math.min(nums[i],Math.min(dpmax[i-1]*nums[i],dpmin[i-1]*nums[i]));
            res = Math.max(res,dpmax[i]);
        }

        return res;
    }
}
