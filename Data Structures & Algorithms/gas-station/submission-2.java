class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0;
        int total = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            int diff = gas[i]-cost[i];
            total = total+diff;
            currentGas = currentGas+diff;

            if(currentGas<0){
                start=i+1;
                currentGas=0;
            }
        }

        return total>0?start:-1;
    }
}
