class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        int first = -1;
        int second = -1;


        for(int i = 0; i<nums.length; i++){
            if(hashMap.containsKey(target-nums[i])){
                first = hashMap.get(target-nums[i]);
                second = i;
                break;
            }else{
                hashMap.put(nums[i],i);
            }
        }

        result[0]=first;
        result[1]=second;
        return result;
        
    }
}
