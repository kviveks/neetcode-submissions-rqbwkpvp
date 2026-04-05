class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backTrack(0,nums,target,new ArrayList<Integer>());
        return res;    
    }

    public void backTrack(int p, int[] nums, int target, List<Integer> curr){
        if(target < 0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = p;i<nums.length;i++){
            curr.add(nums[i]);
            backTrack(i,nums,target-nums[i],curr);
            curr.remove(curr.size()-1);
        }
    }
}
