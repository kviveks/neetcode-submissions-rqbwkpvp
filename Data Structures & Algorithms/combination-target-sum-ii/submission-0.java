class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates,target,curr,0);
        return res;
    }

    public void backtrack(int[] candidates, int target,List<Integer> curr,int i){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || i >= candidates.length){
            return;
        }

        curr.add(candidates[i]);
        backtrack(candidates,target-candidates[i],curr,i+1);
        curr.remove(curr.size()-1);
        backtrack(candidates,target,curr,i+1);
    }
}
