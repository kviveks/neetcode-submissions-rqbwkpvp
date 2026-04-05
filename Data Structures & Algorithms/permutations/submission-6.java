class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new HashSet<>(),new ArrayList<>());
        return res;
    }


    public void dfs(int[] nums, Set<Integer> visited, List<Integer> curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(visited.contains(nums[i])){
                continue;
            }
            visited.add(nums[i]);
            curr.add(nums[i]);
            dfs(nums,visited,curr);
            visited.remove(nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}
