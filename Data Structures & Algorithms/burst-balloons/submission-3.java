class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }


        dp = new int[n+2][n+2];

        return dfs(1,n,arr);
    }


    public int dfs(int l,int r,int[] nums){
        if(l>r)
            return 0;

        if(dp[l][r]!=0) return dp[l][r];

        int best = 0;

        for(int i=l;i<=r;i++){
            int coins = nums[l-1]*nums[i]*nums[r+1] + dfs(l,i-1,nums)+dfs(i+1,r,nums);
            best =Math.max(coins,best);
        }

        dp[l][r]=best;

        return best;
    }
}
