class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffixSum = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        Integer[][] dp = new Integer[n][n + 1];

        return dfs(0, 1, piles, suffixSum, dp);
    }

    private int dfs(int i, int m, int[] piles, int[] suffixSum, Integer[][] dp) {
        int n = piles.length;

        if (i >= n) {
            return 0;
        }

        if (2 * m >= n - i) {
            return suffixSum[i];
        }

        if (dp[i][m] != null) {
            return dp[i][m];
        }

        int best = 0;

        for (int x = 1; x <= 2 * m; x++) {
            int opponent = dfs(i + x, Math.max(m, x), piles, suffixSum, dp);
            int current = suffixSum[i] - opponent;

            best = Math.max(best, current);
        }

        dp[i][m] = best;
        return best;
    }
}