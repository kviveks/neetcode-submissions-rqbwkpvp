class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        if(cost.length<2){
            return 0;
        }
        minCost[0]=0;
        minCost[1]=0;
        for(int i = 2;i<cost.length;i++){
            minCost[i]=Math.min(minCost[i-1]+cost[i-1],minCost[i-2]+cost[i-2]);
        } 

        return Math.min(minCost[cost.length-1],minCost[cost.length-2]);   
    }
}
