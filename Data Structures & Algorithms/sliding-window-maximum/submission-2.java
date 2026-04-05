class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // first window
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = map.lastKey();

        // slide window
        for (int i = k; i < n; i++) {

            // add new element
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // remove outgoing element
            int out = nums[i - k];
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) {
                map.remove(out);
            }

            result[i - k + 1] = map.lastKey();
        }

        return result;
    }
}
