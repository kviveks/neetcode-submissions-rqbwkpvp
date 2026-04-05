class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,new ArrayList<>(),0);
        return res;
    }

    public void dfs(int[] nums,List<Integer> curr,int p){
        if(p>nums.length)
            return;

        res.add(new ArrayList<>(curr));

        for(int i = p;i<nums.length;i++){
            curr.add(nums[i]);
            dfs(nums,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
