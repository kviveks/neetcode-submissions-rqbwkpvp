class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();   
        backtrack(0,nums,new ArrayList<Integer>());
        return res;    
    }


    public void backtrack(int p, int[] nums, List<Integer> curr){
        if(p>nums.length){
            return;
        }

        res.add(new ArrayList<Integer>(curr));

        for(int i = p; i< nums.length; i++){
            curr.add(nums[i]);
            backtrack(i+1,nums,curr);
            curr.remove(curr.size()-1);
        }
    }
}
