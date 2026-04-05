class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(new ArrayList<>(),target,candidates,0);
        return res;    
    }

    public void dfs(List<Integer> curr,int target,int[] candidates,int p){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0){
            return;
        }


        for(int i = p;i<candidates.length;i++){
            if(i>p && candidates[i-1]==candidates[i])
                continue;
            curr.add(candidates[i]);
            dfs(curr,target-candidates[i],candidates,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
