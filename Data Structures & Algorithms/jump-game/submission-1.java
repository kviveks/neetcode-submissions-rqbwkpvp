class Solution {
    public boolean canJump(int[] nums) {

        int[] posible = new int[nums.length];
        posible[0] = 1;
        for(int i = 0;i < nums.length;i++){
            if(posible[i]!=1)
                continue;
            int num = nums[i];
            for(int j = 1;j<=num && i+j<nums.length;j++){
                posible[i+j] = 1;    
            }
        }

        if(posible[nums.length-1]==1){
            return true;
        }

        return false;    
    }
}
