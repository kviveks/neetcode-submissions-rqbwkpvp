class Solution {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        for(int i = 0; i < n; i++){
            adjMap.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjMap.get(u).add(v);
            adjMap.get(v).add(u);
        }

        if(!dfs(0, -1)){
            return false;
        }

        return visited.size() == n;
    }

    public boolean dfs(int node, int parent){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);

        for(int neighbor : adjMap.get(node)){
            if(neighbor == parent) continue;

            if(!dfs(neighbor, node)){
                return false;
            }
        }
        return true;
    }
}