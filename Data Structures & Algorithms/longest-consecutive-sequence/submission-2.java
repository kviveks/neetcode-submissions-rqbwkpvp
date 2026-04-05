class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int globalMax = -1;
        int localMax = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]+1==nums[i+1]){
                localMax=localMax+1;
            }else if(nums[i]==nums[i+1]){
                continue;
            }else{
                globalMax = Math.max(globalMax,localMax);
                localMax = 0;
            }
        }

        globalMax = Math.max(globalMax,localMax);

        return globalMax;
    }
}
