class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);  // Convert wordDict to a Set for O(1) lookup
        Set<Integer> validWordStart = new HashSet<>();  // Set to track valid start indices
        validWordStart.add(n);  // Base case: the position after the end is valid (empty string is valid)

        // Start from the end and go backwards
        for (int i = n - 1; i >= 0; i--) {
            // For each valid start, check if a substring from i to that start exists in the wordDict
            for (int index : validWordStart) {
                String sub = s.substring(i, index);  // Check the substring from i to index
                if (wordSet.contains(sub)) {
                    validWordStart.add(i);  // If it's valid, mark i as a valid start
                    break;  // No need to continue checking once a valid substring is found
                }
            }
        }

        // If 0 is in validWordStart, it means the whole string can be broken into valid words
        return validWordStart.contains(0);
    }
}