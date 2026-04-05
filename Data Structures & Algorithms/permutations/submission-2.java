class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums,new HashSet<Integer>(),new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] nums,HashSet<Integer> set,List<Integer> curr){
        if(set.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            curr.add(nums[i]);
            set.add(nums[i]);
            dfs(nums,set,curr);
            curr.remove(curr.size()-1);
            set.remove(nums[i]);
        }
    }
}
