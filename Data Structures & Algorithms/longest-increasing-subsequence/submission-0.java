

class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int max = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            Integer higher = treeMap.higherKey(nums[i]);
            int length = 1;
            if (higher != null) {
                length = treeMap.get(higher) + 1;
            }

            // Only update if we're improving the stored value
            treeMap.put(nums[i], Math.max(treeMap.getOrDefault(nums[i], 0), length));
            max = Math.max(max, length);
        }

        return max;
    }
}

