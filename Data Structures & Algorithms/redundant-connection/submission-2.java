class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
            visited = new HashSet<>();
            if(!dfs(u,-1)){
                return new int[]{u,v};
            }    
        }

        return new int[]{-1,-1};

    }

    public boolean dfs(int node,int parent){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);


        for(int n : adj.get(node)){
            if(n==parent){
                continue;
            }
            if(!dfs(n,node)){
                return false;
            }
        }

        return true;
    }
}
