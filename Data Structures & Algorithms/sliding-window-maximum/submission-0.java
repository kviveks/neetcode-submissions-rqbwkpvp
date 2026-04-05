class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k == 0) return new int[0];

        List<Integer> res = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        // first window
        for (int i = 0; i < k; i++) {
            set.add(nums[i]);
        }
        res.add(set.last());

        // sliding window
        for (int r = k; r < nums.length; r++) {
            set.remove(nums[r - k]);
            set.add(nums[r]);
            res.add(set.last());
        }

        // convert to array
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
