class Solution {
    public int search(int[] nums, int target) {
        int mid = 0;
        int start = 0,end = nums.length;

        while(start<=end && start>=0 && end < nums.length){
            mid = start + (end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        } 

        return -1;   
    }
}
