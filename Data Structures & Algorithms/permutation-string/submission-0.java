class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Char = new int[26];
        int[] s2Char = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Char[s1.charAt(i) - 'a']++;
            s2Char[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (i != 0) {
                s2Char[s2.charAt(i - 1) - 'a']--;
                s2Char[s2.charAt(i + s1.length() - 1) - 'a']++;
            }

            boolean match = true;
            for (int j = 0; j < 26; j++) {
                if (s1Char[j] != s2Char[j]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return true;
            }
        }

        return false;
    }
}
