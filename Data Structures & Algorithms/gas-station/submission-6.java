class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasDiff = 0;
        int start = 0;
        int currentGas = 0;
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];

            currentGas += diff;
            totalGasDiff += diff;

            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        return totalGasDiff >= 0 ? start : -1;
    }
}