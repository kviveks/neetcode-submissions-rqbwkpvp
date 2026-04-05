class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums,target,new ArrayList<>(),0);
        return res;
    }

    public void backTrack(int[] nums,int target,List<Integer> currentList,int i){
        if(target<0){
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(currentList));
        }


        for(int j = i;j<nums.length;j++){
            currentList.add(nums[j]);
            backTrack(nums,target-nums[j],currentList,j);
            currentList.remove(currentList.size()-1);
        }
    }
}
