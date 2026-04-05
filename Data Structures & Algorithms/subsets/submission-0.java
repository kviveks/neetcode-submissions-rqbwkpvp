class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),res);
        res.add(new ArrayList<Integer>());
        return res;
        
    }

    public static void backtrack(int[] nums,int i,List<Integer> subset,List<List<Integer>> res){
        if(i==nums.length){
            return;
        }

        List<Integer> copy1 = new ArrayList<>();
        List<Integer> copy2 = new ArrayList<>();
        copy1.addAll(subset);
        copy2.addAll(subset);
        copy2.add(nums[i]);
        res.add(copy2);

        backtrack(nums,i+1,copy1,res);
        backtrack(nums,i+1,copy2,res);
    }

}
