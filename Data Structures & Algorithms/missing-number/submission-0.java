class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=0;i<=n;i++){
            res = res ^ i;
        }

        for(int num : nums){
            res = res ^ num;
        }

        return res;
    }
}
