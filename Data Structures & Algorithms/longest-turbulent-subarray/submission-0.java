class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int r = 1;
        int res = 1;
        int prev = 0;

        while (r < arr.length) {
            int curr = Integer.compare(arr[r - 1], arr[r]);

            if (curr != 0 && curr != prev) {
                res = Math.max(res, r - l + 1);
                prev = curr;
                r++;
            } else {
                if (curr == 0) {
                    r++;
                }

                l = r - 1;
                prev = 0;
            }
        }

        return res;
    }
}