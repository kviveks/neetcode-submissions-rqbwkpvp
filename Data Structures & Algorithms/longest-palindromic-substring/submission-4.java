class Solution {
    int left=0;
    int right=1;
    int globalMax = 1;
    public String longestPalindrome(String s) {
        for(int m=0;m<s.length();m++){
            checkPalindrome(m,s);
        }

        return s.substring(left,right+1);
    }

    public void checkPalindrome(int m,String s){
        int l = m;
        int r = m;
        //odd length
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(globalMax < r-l+1){
                globalMax = r-l+1;
                left=l;
                right=r;
            }
            l--;
            r++;
        }


        l = m;
        r = m+1;
        //even length
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(globalMax < r-l+1){
                globalMax = r-l+1;
                left=l;
                right=r;
            }
            l--;
            r++;
        }
    }
}
