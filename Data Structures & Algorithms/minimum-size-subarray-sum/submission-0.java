class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;

        for(int r=0;r<nums.length;r++){
            currentSum +=nums[r];
            if(currentSum>=target){ 
                do{
                    res = Math.min(res,r-l+1);
                    currentSum = currentSum - nums[l++];
                }while(currentSum>=target);
            }
        }

        return res == Integer.MAX_VALUE ?0:res;
    }
}