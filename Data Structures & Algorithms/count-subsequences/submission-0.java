public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Create a 2D DP array with (m+1) rows and (n+1) columns
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: An empty string t can be formed from any prefix of s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;  // There's exactly one way to match an empty string t (by deleting all characters from s)
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If characters match, we can either include or exclude s[i-1]
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    // If characters don't match, we can only exclude s[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // The answer is the number of ways to form the entire string t from the entire string s
        return dp[m][n];
    }
}
