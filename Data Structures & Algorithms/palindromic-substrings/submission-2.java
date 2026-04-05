class Solution {
    int count = 0;
    public int countSubstrings(String s) {


        for(int m = 0;m<s.length();m++){
            checkPalindrome(m,s);
        }

        return count;
        
    }

    public void checkPalindrome(int m,String s){
        int l=m,r=m;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }

        l=m;
        r=m+1;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;    
        }
    }
}
