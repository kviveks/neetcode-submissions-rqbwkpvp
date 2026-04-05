class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNumber = new HashSet<>();
        for(Integer num : nums){
            if(uniqueNumber.contains(num)){
                return true;
            }
            uniqueNumber.add(num);
        }

        return false;
    }
}