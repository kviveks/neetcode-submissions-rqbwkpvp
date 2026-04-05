class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(0,nums,target,new ArrayList<Integer>());
        return res;
    }

    public void backTrack(int p,int[] nums,int target, List<Integer> curr){
        if(target < 0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(curr));
        }

        int removed = -1;
        for(int i = p;i<nums.length;i++){
            while(removed==nums[i]){
                i++;
            }
            curr.add(nums[i]);
            backTrack(i+1,nums,target-nums[i],curr);
            removed = curr.get(curr.size()-1);
            curr.remove(curr.size()-1);
        }
    }
}
