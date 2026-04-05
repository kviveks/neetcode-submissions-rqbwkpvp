class Solution {
    public int jump(int[] nums) {

        if(nums.length==1){
            return 0;
        }
        int count=0;
        int maxJump = 0;
        for(int i=0;i<nums.length;i++){
            if(maxJump<i){
                return -1;
            }

            if(maxJump<i+nums[i]){
                count++;
                maxJump = i+nums[i];
            }

            if(maxJump>=nums.length-1){
                return count;
            }
        }

        return -1;    
    }
}
