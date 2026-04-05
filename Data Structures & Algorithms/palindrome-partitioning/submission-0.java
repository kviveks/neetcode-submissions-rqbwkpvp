class Solution {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backTrack(0, s, new ArrayList<>());
        return res;
    }

    public void backTrack(int start, String s, List<String> curr) {
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPal(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                backTrack(end + 1, s, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
