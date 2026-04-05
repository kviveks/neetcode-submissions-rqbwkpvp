// for valid tree it should be connected
// and no cycle
class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        boolean res = dfs(0);
        if(res && visited.size()==n){
            return true;
        }

        return false;
    }


    public boolean dfs(int node){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        boolean res = true;
        for(int n : adj.get(node)){
            res = res && dfs(n);    
        }

        if(res){
            return true;
        }

        return false;
    }
}
