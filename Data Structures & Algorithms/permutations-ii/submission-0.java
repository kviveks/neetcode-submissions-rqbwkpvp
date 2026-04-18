class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,new ArrayList<>(),new HashSet<>());
        return res;
    }

    public void dfs(int[] nums,List<Integer> curr,Set<Integer> visited){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited.contains(i)){
                continue;
            }

            if(i>0 && nums[i-1]==nums[i] && !visited.contains(i-1))
                continue;

            curr.add(nums[i]);
            visited.add(i);
            dfs(nums,curr,visited);
            curr.remove(curr.size()-1);
            visited.remove(i);
        }
    }
}