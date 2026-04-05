class Solution {
    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()];

        dp[0]=1;
        for(int i = 1;i<s.length();i++){
            int num = s.charAt(i)-'0';
            int value = 0;
            if(num>=1 && num <=9){
                value = value + dp[i-1];
            }

            num = Integer.parseInt(s.substring(i-1,i+1));
            if(num >=1 && num <=26){
                if(i-2>=0)
                value = value + dp[i-2];
                else
                value = value+1;
            }
            dp[i]=value;
        }

        return dp[s.length()-1];        
    }
}
