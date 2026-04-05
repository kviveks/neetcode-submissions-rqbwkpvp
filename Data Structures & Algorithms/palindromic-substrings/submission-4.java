class Solution {
    int res = 0;
    public int countSubstrings(String s) {
        for(int m=0;m<s.length();m++){
            checkPalindrome(m,s);
        }

        return res;
    }

    public void checkPalindrome(int m,String s){
        int l = m;
        int r = m;

        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            res++;
            l--;
            r++;
        }
        l=m;
        r=m+1;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            res++;
            l--;
            r++;
        }
    }
}
