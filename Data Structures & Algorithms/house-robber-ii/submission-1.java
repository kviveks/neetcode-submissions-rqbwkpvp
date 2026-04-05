class Solution {
    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }
        
        int[] loot = new int[nums.length];

        loot[0]=nums[0];
        loot[1]=Math.max(nums[0],nums[1]);

        for(int i = 2;i<nums.length-1;i++){
            loot[i]=Math.max(loot[i-1],loot[i-2]+nums[i]);
        }

        int case1loot = loot[nums.length-2];

        loot[0]=0;
        loot[1]=nums[1];

        for(int i = 2; i<nums.length;i++){
            loot[i]=Math.max(loot[i-1],loot[i-2]+nums[i]);
        }

        int case2loot = loot[nums.length-1];

        return Math.max(case1loot,case2loot);



    }
}
