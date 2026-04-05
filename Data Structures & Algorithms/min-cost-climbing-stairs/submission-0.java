class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] step = new int[cost.length];

        step[0]=0;
        step[1]=0;

        for(int i=2;i<cost.length;i++){
            step[i]=Math.min(step[i-1]+cost[i-1],step[i-2]+cost[i-2]);
        }

        int n = cost.length;

        return Math.min(step[n-1]+cost[n-1],step[n-2]+cost[n-2]);
        
    }
}
