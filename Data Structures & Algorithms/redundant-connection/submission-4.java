class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        for(int i=1;i<=n;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjMap.get(u).add(v);
            adjMap.get(v).add(u);
            visited = new HashSet<>();
            if(!dfs(u,-1)){
                return new int[]{u,v};
            }
        }

        return new int[]{-1,-1};
    }

    public boolean dfs(int node, int parent){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        boolean res = true;
        for(int i=0;i<adjMap.get(node).size();i++){
            if(parent==adjMap.get(node).get(i))
                continue;
            res = res && dfs(adjMap.get(node).get(i),node);
        }
        return res;

    }
}
