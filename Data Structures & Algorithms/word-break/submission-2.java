

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);  // Convert wordDict to a Set for O(1) lookup
        boolean[] dp = new boolean[n + 1];  // DP array to track if substring s[0..i-1] is valid
        dp[0] = true;  // Base case: empty string can always be "broken"

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // No need to continue checking for earlier indices
                }
            }
        }

        return dp[n];  // Return true if the entire string can be broken
    }
}
