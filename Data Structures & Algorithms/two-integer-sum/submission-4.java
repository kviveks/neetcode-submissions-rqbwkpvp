class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> uNum = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(uNum.containsKey(target-nums[i])){
                return new int[]{uNum.get(target-nums[i]),i};
            }else{
                uNum.put(nums[i],i);
            }
        }

        return null;
    }
}
