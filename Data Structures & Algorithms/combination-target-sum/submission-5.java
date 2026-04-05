class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(0,new ArrayList<>(),target,nums);
        return res;
    }

    public void dfs(int p, List<Integer> sub,int target,int[] nums){

        if(p >= nums.length || target < 0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int i=p;i<nums.length;i++){
            sub.add(nums[i]);
            dfs(i,sub,target-nums[i],nums);
            sub.remove(sub.size()-1);
        }


    }
}
