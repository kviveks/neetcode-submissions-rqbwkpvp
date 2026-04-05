class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){

            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int num1 = nums[i];
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum = nums[l]+nums[r];
                if(sum+num1==0){
                    res.add(Arrays.asList(num1,nums[l],nums[r]));
                    break;
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
