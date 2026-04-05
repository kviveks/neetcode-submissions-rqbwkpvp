//    0 1 2 3 4 5
// 0
// 1
// 2
// 3
// 4
// 5

// (0,2) (1,3) (2,4) (3,5)


class Solution {
    public int countSubstrings(String s) {
        
        int length = s.length();
        int[][] dp = new int[length][length];
        int count = 0;
        for(int start = 0;start<length ; start++){
            dp[start][start] = 1;
            count++;
        }

        for(int end=1;end<length;end++){
            if(s.charAt(end-1)==s.charAt(end)){
                dp[end-1][end] = 1;
                count++;
            }
        }
        
        for(int i=2;i<length;i++){
            for(int j = 0;j<length-i;j++){
                int start = j;
                int end = j+i;
                if(s.charAt(start)==s.charAt(end) && dp[start+1][end-1]==1){
                    dp[start][end]=1;
                    count++;
                }
            }
        }

        return count;

        
    }
}
