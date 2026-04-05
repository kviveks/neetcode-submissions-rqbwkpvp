class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums,int p,List<Integer> curr){
        res.add(new ArrayList<>(curr));

        if(p>=nums.length){
            return;
        }

        for(int i=p;i<nums.length;i++){
            if(i>p && nums[i-1]==nums[i]){
                continue;
            }
            curr.add(nums[i]);
            dfs(nums,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}
