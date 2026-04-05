class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] nums,List<Integer> curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<Integer>(curr));
        }
        
        for(int i=0;i<nums.length;i++){
            if(visited.contains(nums[i]))
                continue;
            curr.add(nums[i]);
            visited.add(nums[i]);
            dfs(nums,curr);
            curr.remove(curr.size()-1);
            visited.remove(nums[i]);
        }
    }
}
