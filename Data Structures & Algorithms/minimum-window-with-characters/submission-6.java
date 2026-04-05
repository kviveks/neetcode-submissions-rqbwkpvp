class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // 1. Map out what we NEED
        int[] targetCount = new int[128]; // Use 128 for all ASCII chars
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        int[] windowCount = new int[128];
        int have = 0;
        int need = 0;
        // Calculate how many unique characters in t have a count > 0
        for (int i : targetCount) {
            if (i > 0) need++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // 2. The Scout starts moving (right pointer)
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCount[c]++;

            // If we just hit the exact requirement for this char
            if (targetCount[c] > 0 && windowCount[c] == targetCount[c]) {
                have++;
            }

            // 3. The Manager starts shrinking (left pointer)
            while (have == need) {
                // Update our record if this window is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                // Remove the character at 'left' and move forward
                char leftChar = s.charAt(left);
                windowCount[leftChar]--;

                // If removing this char makes the window invalid
                if (targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}