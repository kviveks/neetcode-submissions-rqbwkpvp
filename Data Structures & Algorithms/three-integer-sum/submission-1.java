class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i<nums.length-2;i++){

            if(nums[i]>0){
                break;
            }

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int a = nums[i];
            int l = i+1;
            int r = nums.length-1;

            while(l<r){
                int b = nums[l];
                int c = nums[r];
                if(a+b+c>0){
                    r--;
                }else if(a+b+c<0){
                    l++;
                }else{
                    result.add(Arrays.asList(a,b,c));
                    l++;
                    r--;
                }
            }
        }

        return result;
        
    }
}
