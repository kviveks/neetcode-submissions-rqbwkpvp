class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {    
        dfs(nums,new HashSet<>(),new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums,Set<Integer> visited,List<Integer> curr){
        if(curr.size()>nums.length){
            return;
        }

        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
        }

        for(int i=0;i<nums.length;i++){
            if(visited.contains(i)){
                continue;
            }
            visited.add(i);
            curr.add(nums[i]);
            dfs(nums,visited,curr);
            visited.remove(i);
            curr.remove(curr.size()-1);
        }

    }
}
