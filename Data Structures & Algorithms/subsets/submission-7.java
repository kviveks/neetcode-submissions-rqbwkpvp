class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(),nums,0);
        return res;
    }

    public void dfs(List<Integer> curr, int[] nums, int p){
        res.add(new ArrayList<>(curr));

        if(p>=nums.length){
            return;
        }

        for(int i=p;i<nums.length;i++){
            curr.add(nums[i]);
            dfs(curr,nums,i+1);
            curr.remove(curr.size()-1);
        }

    }
}
