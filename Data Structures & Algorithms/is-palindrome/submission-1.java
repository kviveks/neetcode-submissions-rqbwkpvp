class Solution {
    public boolean isPalindrome(String s) {

        int l = s.length();
        int right = l-1, left = 0;

        while(left<right){
            while(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(right))!=Character.toLowerCase(s.charAt(left))){
                return false;
            }

            left++;
            right--;
            
        }

        return true;

        
        
    }
}
