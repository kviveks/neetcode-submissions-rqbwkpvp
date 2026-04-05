class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];


        for(int i =0;i<2*n;i++){
            if(i<n)
                res[i]=nums[i];
            else
                res[i]=nums[i-n];
        }

        return res;
        
    }
}