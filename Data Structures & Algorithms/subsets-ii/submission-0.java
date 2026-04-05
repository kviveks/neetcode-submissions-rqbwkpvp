class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums,0,new ArrayList<>());
        return res;   
    }

    public void backTrack(int[] nums,int i,List<Integer> currentList){

        res.add(new ArrayList<>(currentList));

        for(int j = i;j<nums.length;j++){
            if(j > i && nums[j]==nums[j-1]){
                continue;
            }
            currentList.add(nums[j]);
            backTrack(nums,j+1,currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}
