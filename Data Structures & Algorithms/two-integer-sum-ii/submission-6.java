class Solution {
    public int[] twoSum(int[] num, int target) {
        int l=0;
        int r=num.length-1;

        while(l<r){
            if(num[l]+num[r]<target){
                l++;
            }else if(num[l]+num[r]>target){
                r--;
            }else{
                return new int[]{l+1,r+1};
            }
        }

        return new int[]{-1,-1};
    }
}
