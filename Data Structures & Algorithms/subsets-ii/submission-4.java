class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0,new ArrayList<>(),nums);
        return res;
    }

    public void dfs(int p,List<Integer> curr,int[] nums){
        res.add(new ArrayList<>(curr));

        if(p==nums.length)
            return;


        for(int i =p;i<nums.length;i++){
            if(i>p && nums[i] == nums[i-1])
                continue;
            curr.add(nums[i]);
            dfs(i+1,curr,nums);
            curr.remove(curr.size()-1);
        }
    }
}
