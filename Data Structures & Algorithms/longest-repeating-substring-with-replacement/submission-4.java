class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];  // Array to count the frequency of each character in the window
        int l = 0;  // Left pointer
        int maxLength = 0;  // Result for the maximum length of the substring
        int maxCount = 0;  // Maximum frequency of the most common character in the current window

        // Traverse the string with the right pointer
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;  // Increment the count of the character at position r

            maxCount = Math.max(maxCount, count[s.charAt(r) - 'A']);  // Update the maxCount

            // If the window size minus the frequency of the most common character exceeds k, shrink the window
            while (r - l + 1 - maxCount > k) {
                count[s.charAt(l) - 'A']--;  // Decrement the count of the character at position l
                l++;  // Move the left pointer rightward
            }

            maxLength = Math.max(maxLength, r - l + 1);  // Update the maxLength
        }

        return maxLength;  // Return the longest valid substring length
    }
}