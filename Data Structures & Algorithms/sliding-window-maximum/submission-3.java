class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int n = nums.length;
        int[] res = new int[n - k + 1];

        int l = 0;

        for (int r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            if (r >= k - 1) {
                res[r - k + 1] = map.lastKey();

                if (map.get(nums[l]) == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], map.get(nums[l]) - 1);
                }

                l++;
            }
        }

        return res;
    }
}