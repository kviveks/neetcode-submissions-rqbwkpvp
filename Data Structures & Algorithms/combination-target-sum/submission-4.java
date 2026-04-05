class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int target, int index, List<Integer> curr) {
        // SUCCESS condition
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // FAILURE condition
        if (target < 0) return;

        // Try each candidate starting from index
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(nums, target - nums[i], i, curr); // reuse allowed
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}
