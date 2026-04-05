class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<Integer>());
        return res;
    }


    public void backtrack(int[] nums, int i, List<Integer> currentList){
        // if(i==nums.length){
        //     return;
        // }

        res.add(new ArrayList<>(currentList));

        for (int j = i; j < nums.length; j++) {
            currentList.add(nums[j]);
            backtrack(nums, j + 1, currentList);
            currentList.remove(currentList.size() - 1);
        }       
    }
}
