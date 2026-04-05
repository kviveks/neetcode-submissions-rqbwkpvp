class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,target,0,new ArrayList<>());
        return res;   
    }

    public void backTrack(int[] candidates, int target,int i,List<Integer> currentList){
        if(target<0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(currentList));
        }

        for(int j = i; j< candidates.length; j++){
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            currentList.add(candidates[j]);
            backTrack(candidates,target-candidates[j],j+1,currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}
