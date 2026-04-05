import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        // Frequency map for characters in t
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int required = targetCount.size();
        Map<Character, Integer> windowCount = new HashMap<>();
        int formed = 0; // To track how many unique characters in the window are satisfying the condition
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0; // Store the starting index of the minimum window

        // Start sliding window
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            // If the current character's frequency matches the target frequency in t
            if (windowCount.get(c).equals(targetCount.get(c))) {
                formed++;
            }

            // Try to shrink the window as much as possible
            while (left <= right && formed == required) {
                // Update minimum window if it's smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Move left pointer to shrink the window
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (windowCount.get(leftChar) < targetCount.getOrDefault(leftChar, 0)) {
                    formed--;
                }
                left++;
            }

            // Expand the window by moving the right pointer
            right++;
        }

        // If no valid window found, return an empty string
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
