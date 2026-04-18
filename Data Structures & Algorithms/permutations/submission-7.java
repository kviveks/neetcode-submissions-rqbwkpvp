class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new ArrayList<>(),new HashSet<>());
        return res;
    }

    public void dfs(int[] nums,List<Integer> curr,Set<Integer> visited){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited.contains(nums[i]))
                continue;

            curr.add(nums[i]);
            visited.add(nums[i]);
            dfs(nums,curr,visited);
            curr.remove(curr.size()-1);
            visited.remove(nums[i]);
        }
    }
}
