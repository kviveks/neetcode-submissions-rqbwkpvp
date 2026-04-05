class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,new ArrayList<>(),nums);
        return res;
    }

    public void dfs(int p,List<Integer> sub,int[] nums){
        if(p>nums.length){
            return;
        }

        res.add(new ArrayList<>(sub));

        for(int i=p;i<nums.length;i++){
            if(i>p && nums[i-1]==nums[i])
                continue;
            int n = nums[i];
            sub.add(n);
            dfs(i+1,sub,nums);
            sub.remove(sub.size()-1);
        }
    }
}
