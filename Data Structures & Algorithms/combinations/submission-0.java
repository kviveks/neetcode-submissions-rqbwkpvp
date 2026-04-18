class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,new ArrayList<>(),1);
        return res;
    }

    public void dfs(int n,int k,List<Integer> curr,int p){
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }


        for(int i=p;i<=n;i++){
            curr.add(i);
            dfs(n,k,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}