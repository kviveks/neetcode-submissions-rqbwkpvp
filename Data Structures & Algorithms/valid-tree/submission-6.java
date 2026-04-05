class Solution {

    Map<Integer,List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        // Important optimization
        if(edges.length != n - 1) return false;

        // build graph
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // undirected
        }

        // check cycle
        if(!dfs(0,-1)) return false;

        // check connected
        return visited.size() == n;
    }

    public boolean dfs(int node,int parent){

        visited.add(node);

        for(int nei : adj.get(node)){

            if(nei == parent) continue;

            if(visited.contains(nei)) return false;

            if(!dfs(nei,node)) return false;
        }

        return true;
    }
}
