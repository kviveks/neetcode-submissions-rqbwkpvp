class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        int[] minJump = new int[n];

        for(int i = 1; i<n; i++){
            minJump[i] = Integer.MAX_VALUE;
        }

        for(int i = 0;i < n;i++){
            int num = nums[i];
            if(num==Integer.MAX_VALUE){
                continue;
            }

            for(int j = 1;j<=num && i+j< n;j++){
                minJump[i+j]= Math.min(minJump[i+j],minJump[i]+1);
            }
        }

        return minJump[n-1];
        
    }
}
