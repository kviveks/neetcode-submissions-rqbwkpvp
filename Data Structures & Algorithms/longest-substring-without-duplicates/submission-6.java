class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int globalMax = 0;
        int currentStart = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is already in the substring, move the start position
            if (lastIndex.containsKey(currentChar) && lastIndex.get(currentChar) >= currentStart) {
                currentStart = lastIndex.get(currentChar) + 1;
            }

            // Update the last index of the current character
            lastIndex.put(currentChar, i);

            // Calculate the length of the current valid substring
            globalMax = Math.max(globalMax, i - currentStart + 1);
        }

        return globalMax;
    }
}
