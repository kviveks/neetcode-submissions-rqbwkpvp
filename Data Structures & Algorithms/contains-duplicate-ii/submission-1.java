class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0;int r=1;
        Map<Integer,Integer> map = new HashMap<>();// number,freq
        while(r-l<=k && r<nums.length){
            map.putIfAbsent(nums[r],0);
            map.put(nums[r],map.get(nums[r])+1);
            if(map.containsKey(nums[l])){
                return true;
            }

            if(r-l==k){
                l++;
                if(map.get(nums[l])==1){
                    map.remove(nums[l]);
                }else{
                    map.put(nums[l],map.get(nums[l])-1);
                }
            }
            r++;
        }

        return false;
    }
}