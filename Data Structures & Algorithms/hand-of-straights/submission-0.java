class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        int[] pigenHole = new int[10001]; // since numbers can go up to 10000
        int min = 10001, max = 0;

        for (int num : hand) {
            pigenHole[num]++;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = min; i <= max; i++) {
            while (pigenHole[i] > 0) {
                int count = pigenHole[i];
                // Try to build a group of groupSize starting from i
                for (int j = 0; j < groupSize; j++) {
                    if (pigenHole[i + j] < count) {
                        return false;
                    }
                    pigenHole[i + j] -= count;
                }
            }
        }

        return true;
    }
}
