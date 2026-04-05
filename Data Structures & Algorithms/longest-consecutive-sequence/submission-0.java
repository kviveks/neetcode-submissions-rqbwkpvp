class Solution {
    public int longestConsecutive(int[] nums) {
        
    Set<Integer> set = new HashSet<>();
    int l = nums.length;
    for(int i = 0; i<l; i++){
        set.add(nums[i]);
    }

    int max = 1;
    int currentMax;
    for(Integer num : nums){
        currentMax = 1;
        if(!set.contains(num-1)){
            int i = 1;
            while(set.contains(num+i)){
                currentMax++;
                i++;
            }
        }
        max=Math.max(max,currentMax);
    }

    return max;
}
}
