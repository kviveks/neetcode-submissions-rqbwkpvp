//   a b a b d
//   0 1 2 3 4
// 0
// 1
// 2
// 3
// 4



class Solution {
    public String longestPalindrome(String s) {
       //int length = s.length()-1;
       int[][] dp = new int[s.length()][s.length()];
        int maxsize = 1;
        int left = 0;
        int right = 0;
       for(int start = 0;start <s.length();start++){
        dp[start][start] = 1;
       }

       for(int end = 1;end<s.length();end++){
        if(s.charAt(end-1)==s.charAt(end)){
            dp[end-1][end] = 1;
            left = end-1;
            right = end;
        }
       }

       for(int end = 2;end<s.length();end++){
        for(int start = 0; start<s.length()-end;start++){
            if(s.charAt(start)==s.charAt(end) && dp[start+1][end-1]==1){
                dp[start][end]=1;
                if(maxsize<end-start){
                    maxsize=end-start;
                    left=start;
                    right=end;
                }
            }
        }
       }

       return s.substring(left,right+1);



    }
}
