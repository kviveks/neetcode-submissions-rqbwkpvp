class Solution {
    int count=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            checkPalindrome(i,s);
        }    

        return count;
    }

    public void checkPalindrome(int m,String s){
        int l=m;
        int r=m;
        while(l>=0 && r<=s.length()-1&&s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }

        l=m;
        r=m+1;
        while(l>=0 && r<=s.length()-1&&s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }
    }
}
