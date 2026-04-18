class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0);
        return res;
    }

    public void dfs(int[] nums,int target,List<Integer> curr,int p){
        if(target<0){
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }


        for(int i=p;i<nums.length;i++){
            if(i>p && nums[i-1]==nums[i]){
                continue;
            }
            curr.add(nums[i]);
            dfs(nums,target-nums[i],curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
