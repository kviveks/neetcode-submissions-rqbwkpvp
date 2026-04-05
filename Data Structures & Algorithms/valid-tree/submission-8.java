class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(n!=edges.length+1){
            return false;
        }
        for(int i=0;i<n;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjMap.get(u).add(v);
            adjMap.get(v).add(u);
        }


        if(!dfs(0,-1)){
            return false;
        }

        if(visited.size()==n){
            return true;
        }

        return false;
    }


    public boolean dfs(int node,int parent){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        boolean res = true;
        for(int i=0;i<adjMap.get(node).size();i++){
            if(parent ==adjMap.get(node).get(i))
                continue;
            res = res && dfs(adjMap.get(node).get(i),node);
        }

        return res;
    }
}
