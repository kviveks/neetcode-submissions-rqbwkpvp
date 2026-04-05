class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;

        for(int i=0;i<nums.length;i++){
            if(maxJump<i){
                break;
            }
            maxJump = Math.max(maxJump,i+nums[i]);
            if(maxJump>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
