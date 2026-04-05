class Solution {
    public int maxProduct(int[] nums) {
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];

        maxdp[0]=nums[0];
        mindp[0]=nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            maxdp[i]=Math.max(nums[i],maxdp[i-1]*nums[i]);
            maxdp[i]=Math.max(maxdp[i],mindp[i-1]*nums[i]);
            res = Math.max(maxdp[i],res);
            mindp[i]=Math.min(nums[i],maxdp[i-1]*nums[i]);
            mindp[i]=Math.min(mindp[i],mindp[i-1]*nums[i]);
        } 

        return res;   
    }
}
