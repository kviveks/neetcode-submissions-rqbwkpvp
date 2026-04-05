class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;

        for (int p : piles) {
            r = Math.max(r, p);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (calculateHour(piles, mid) > h) {
                l = mid + 1;   // speed too slow
            } else {
                r = mid;       // possible answer
            }
        }

        return l;
    }

    public int calculateHour(int[] piles, int k) {
        int sum = 0;
        for (int p : piles) {
            sum += p / k;
            if (p % k > 0) sum += 1;
        }
        return sum;
    }
}
