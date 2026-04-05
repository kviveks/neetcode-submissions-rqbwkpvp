class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0,nums,new ArrayList<>(),target);
        return res;    
    }

    public void dfs(int p,int[] nums,List<Integer> curr,int target){
        if(target<0 || p >=nums.length){
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(curr));
        }

        for(int i = p;i<nums.length;i++){
            curr.add(nums[i]);
            dfs(i,nums,curr,target-nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}
