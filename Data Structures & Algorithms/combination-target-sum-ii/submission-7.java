class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        dfs(0,new ArrayList<>(),candidates,target);
        return res;   
    }

    public void dfs(int p,List<Integer> sub, int[] candidates,int target){
        if(target < 0){
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(sub));
        }

        for(int i=p;i<candidates.length;i++){
            if(i>p && candidates[i-1]==candidates[i]){
                continue;
            }
            sub.add(candidates[i]);
            dfs(i+1,sub,candidates,target-candidates[i]);
            sub.remove(sub.size()-1);
        }
    }
}
