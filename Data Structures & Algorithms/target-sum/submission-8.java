class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        if(nums.length==1 ){
            if(target==nums[0]|| target==-nums[0])
            return 1;
            else
            return 0;
        }

        int l = nums.length;
        int sum = 0;
        for(int i = 0;i<l;i++){
            sum = sum+nums[i];
        }

        int[][] dp = new int[l][2*sum+1];

        for(int i = 0;i<l; i++){
            int num = nums[i];
            if(i==0){
                dp[i][sum-num]=1;//dp[i][sum-num]+1;
                dp[i][sum+num]=1;//dp[i][sum+num]+1;
            }else{
                for(int j = 0 ; j< 2*sum+1 ;j++){
                    if(dp[i-1][j]!=0){
                        dp[i][j-num]=dp[i][j-num]+dp[i-1][j];
                        dp[i][j+num]=dp[i][j+num]+dp[i-1][j];    
                    }
                }
            }

        }

        return dp[l-1][sum-target];


        
    }
}
