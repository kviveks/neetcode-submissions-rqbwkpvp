class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        dfs(0,candidates,target,new ArrayList<>());
        return res;
    }

    public void dfs(int p,int[] nums, int target,List<Integer> curr){
        if(p>nums.length || target<0){
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(curr));
        }

        for(int i=p;i<nums.length;i++){
            if(i>p && nums[i-1]==nums[i]){
                continue;
            }
            curr.add(nums[i]);
            dfs(i+1,nums,target-nums[i],curr);
            curr.remove(curr.size()-1);
        }
    }
}
