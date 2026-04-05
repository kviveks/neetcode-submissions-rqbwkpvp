class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(new ArrayList<Integer>(),nums,0);
        return res;
    }

    public void dfs(List<Integer> curr,int[] nums,int p){
        if(p>nums.length){
            return;
        }
        res.add(new ArrayList<>(curr));
        for(int i = p;i<nums.length;i++){
            if(i>p&&nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            dfs(curr,nums,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
