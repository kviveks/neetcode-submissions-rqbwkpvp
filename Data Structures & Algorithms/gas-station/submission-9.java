class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int currentDiff = 0;
        int totalDiff = 0;

        for(int i=0;i<gas.length;i++){

            int diff = gas[i]-cost[i];
            totalDiff+=diff;
            currentDiff+=diff;

            if(currentDiff<0){
                start=i+1;
                currentDiff=0;
            }
        }

        return totalDiff>=0?start:-1;
    }
}
