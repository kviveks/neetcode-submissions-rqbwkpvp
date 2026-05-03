class Solution {

    int[][] dp;

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }

        dp = new int[n + 2][n + 2];

        return dfs(1, n, arr);
    }

    private int dfs(int l, int r, int[] nums){

        if(l > r) return 0;

        if(dp[l][r] != 0) return dp[l][r];

        int best = 0;

        for(int i = l; i <= r; i++){

            int coins =
                    nums[l-1] * nums[i] * nums[r+1]
                    + dfs(l, i-1, nums)
                    + dfs(i+1, r, nums);

            best = Math.max(best, coins);
        }

        dp[l][r] = best;

        return best;
    }
}