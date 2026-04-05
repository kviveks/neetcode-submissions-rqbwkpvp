class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l =0;
        int r = nums.length-1;

        for(int i = 0;i<=nums.length-3;i++){
            
            if(i>0&& nums[i] == nums[i-1]) continue;

            int num1 = nums[i];
            l = i+1;
            r = nums.length-1;
            while(l<r){
                int sum = nums[l]+nums[r];
                if(sum+num1==0){
                    res.add(Arrays.asList(num1,nums[l],nums[r]));
                    while(l<r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;

                    l++;
                    r--;
                }else if(sum+num1>0){
                    r--;
                }else{
                    l++;
                }
            }
        }

        return res;

    
    }
}
