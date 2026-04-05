class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets (index = frequency)
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Fill the buckets
        for (int num : freq.keySet()) {
            int f = freq.get(num);
            bucket[f].add(num);
        }

        // Step 3: Collect K elements from highest freq
        int[] result = new int[k];
        int idx = 0;

        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            for (int num : bucket[i]) {
                result[idx++] = num;
                if (idx == k) return result;
            }
        }

        return result; // just in case
    }
}
