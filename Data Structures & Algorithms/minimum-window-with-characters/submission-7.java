class Solution {
    public String minWindow(String s, String t) {
        int[] targetFreq = new int[128];
        int[] currentFreq = new int[128];

        int resL = -1;
        int resR = -1;
        int res = Integer.MAX_VALUE;

        for (char ch : t.toCharArray()) {
            targetFreq[ch]++;
        }

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            currentFreq[ch]++;

            while (isMatch(targetFreq, currentFreq)) {
                if (res > r - l + 1) {
                    res = r - l + 1;
                    resL = l;
                    resR = r;
                }

                currentFreq[s.charAt(l)]--;
                l++;
            }
        }

        return resL == -1 ? "" : s.substring(resL, resR + 1);
    }

    public boolean isMatch(int[] targetFreq, int[] currentFreq) {
        for (int i = 0; i < 128; i++) {
            if (currentFreq[i] < targetFreq[i]) {
                return false;
            }
        }
        return true;
    }
}