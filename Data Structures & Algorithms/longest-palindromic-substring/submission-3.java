class Solution {
    int left = -1;
    int right = -1;
    int globalMax = 0;
    public String longestPalindrome(String s) {


        for(int m = 0;m<s.length();m++){
            checkPalindrome(m,s);
        }

        return s.substring(left,right+1);
        
    }

    public void checkPalindrome(int m,String s){
        int l=m,r=m;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(globalMax<r-l+1){
                globalMax = r-l+1;
                left = l;
                right = r;
            }
            l--;
            r++;
        }

        l=m;
        r=m+1;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(globalMax<r-l+1){
                globalMax = r-l+1;
                left = l;
                right = r;
            }
            l--;
            r++;    
        }
    }
}
