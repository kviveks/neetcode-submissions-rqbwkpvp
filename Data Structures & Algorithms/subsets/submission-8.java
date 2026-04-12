class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    public void dfs(int nums[],int p,List<Integer> curr){
        res.add(new ArrayList<>(curr));

        if(p==nums.length){
            return;
        }


        for(int i=p;i<nums.length;i++){
            curr.add(nums[i]);
            dfs(nums,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}
