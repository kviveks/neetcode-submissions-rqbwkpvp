class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums==null || nums.length<=1){
            return false;
        }  

        Set<Integer> hset = new HashSet<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(hset.contains(nums[i])){
                return true;
            }else{
                hset.add(nums[i]);
            }
        }

        return false;
    }
}