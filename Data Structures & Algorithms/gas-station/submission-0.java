class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i< gas.length; i++){
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];

            total = total+gas[i]-cost[i];
            if(total < 0){
                start = i+1;
                total = 0;
            }
        }

        return totalCost>totalGas ? -1 : start;
    }
}
