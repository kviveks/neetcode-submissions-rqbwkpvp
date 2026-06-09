class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        Set<Integer> validStart = new HashSet<>();
        validStart.add(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int end : new HashSet<>(validStart)) {
                if (wordSet.contains(s.substring(i, end))) {
                    validStart.add(i);
                    break;
                }
            }
        }

        return validStart.contains(0);
    }
}