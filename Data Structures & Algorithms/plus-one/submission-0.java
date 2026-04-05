class Solution {
    public int[] plusOne(int[] digits) {
        int res[] = new int[digits.length+1];
        int carry=0;
        int sum = 0;
        for(int i=digits.length-1;i>=0;i--){
            if(i==digits.length-1){
                sum = digits[i]+1;
            }else{
                sum = digits[i]+carry;
            }

            digits[i]=sum%10;
            carry = sum/10;
        }

        if(carry==0){
            return digits;
        }else{
            res[0]=carry;
            for(int i=0;i<digits.length;i++){
                res[i+1]=digits[i];
            }
            return res;
        }    
    }
}
