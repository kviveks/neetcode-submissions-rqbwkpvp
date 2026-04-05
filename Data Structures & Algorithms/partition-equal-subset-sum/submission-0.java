
class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        int l = nums.length;

        for(int i = 0;i<l;i++){
            sum = sum+nums[i];
        }
        
        if(sum%2!=0){
            return false;
        }

        int requiredSum = sum/2;

        int dp[][] = new int[l][requiredSum+1];
        dp[0][0] = 1;


        for(int j = 1;j<=requiredSum;j++){
            if(nums[0]==j){
                dp[0][j] = 1;
            }
        }

        for(int i = 1;i<l;i++){
            for(int j = 0;j<=requiredSum;j++){
                if(j<nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    if(dp[i-1][j]==1 || dp[i-1][j-nums[i]]==1){
                        dp[i][j] = 1;
                    }
                }

                if(j==requiredSum && dp[i][j]==1){
                    return true;
                }
                

            }
        }

        return false;


    }
}
