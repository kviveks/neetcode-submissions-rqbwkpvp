class Solution {
    public int climbStairs(int n) {
        int[] stair = new int[n];
        stair[0] = 1;

        if(n==1){
            return stair[0];
        }
        stair[1] = 2;


        for(int i =2;i<n;i++){
            stair[i]=stair[i-2]+stair[i-1];
        }

        return stair[n-1];
    }
}
