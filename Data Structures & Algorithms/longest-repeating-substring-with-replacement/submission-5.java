class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int currentMax = 0;
        int l = 0;
        int res = 0;

        for(int r = 0 ;r< s.length();r++){
            char ch = s.charAt(r);
            count[ch-'A']++;

            currentMax = Math.max(currentMax,count[ch-'A']);

            while(r-l+1-currentMax>k){
                count[s.charAt(l)-'A']--;
                l++;
            }

            res = Math.max(res,r-l+1);
        }

        return res;
    }
}
