// 1 2 3 4 5 6

// 3 4 5 6 1 2



class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m = -1;

        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];  // Return the value at index l
    }
}

