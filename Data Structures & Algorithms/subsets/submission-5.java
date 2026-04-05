class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(0,new ArrayList<>(),nums);
        return res;
    }

    public void dfs(int p, List<Integer> sub,int[] nums){
        if(p>nums.length){
            return;
        }

        res.add(new ArrayList<>(sub));
        for(int i = p;i<nums.length;i++){
            sub.add(nums[i]);
            dfs(i+1,sub,nums);
            sub.remove(sub.size()-1);
        }
    }
}
