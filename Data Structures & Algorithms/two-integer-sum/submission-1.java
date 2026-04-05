class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int first = -1;
        int second = -1;
        Map<Integer,Integer> hmap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(target-nums[i])){
                first = hmap.get(target-nums[i]);
                second = i;
                break;
            }else{
                hmap.put(nums[i],i);
            }
        }  

        result[0]=first;
        result[1]=second;
        return result;
    }
}
