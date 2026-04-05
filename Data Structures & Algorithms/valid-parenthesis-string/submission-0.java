//((**)


class Solution {
    public boolean checkValidString(String s) {

        int len = s.length();
        int left = 0;
        int right = len-1;


        while(left<=right){
            if(left==right && s.charAt(left)!='*'){
                return false;
            }

            if(s.charAt(left)==')'){
                return false;
            }

            if(s.charAt(right)=='('){
                return false;
            }

            left++;
            right--;
        }

        return true;


        
    }
}
