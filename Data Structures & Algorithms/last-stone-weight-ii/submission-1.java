


class Solution {
    public int lastStoneWeightII(int[] stones) {
        Arrays.sort(stones);

        int n = stones.length;
        int total = 0;
        for(int stone : stones){
            total+=stone;
        }

        int target = total/2;

        int[][] dp = new int[n+1][target+1];

        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(j>=stones[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return total - 2*dp[n][target];



    }
}