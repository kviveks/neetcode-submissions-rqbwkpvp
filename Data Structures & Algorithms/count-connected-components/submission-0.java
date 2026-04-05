class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer,List<Integer>> adj = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        for(int i =0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        for(Map.Entry<Integer,List<Integer>> entry : adj.entrySet()){
            if(!visited.contains(entry.getKey())){
                res++;
                dfs(entry.getKey());
            }
        }

        return res;
    }

    public void dfs(int n){
        if(visited.contains(n)){
            return;
        }

        visited.add(n);
        
        for(int num : adj.get(n)){
            if(!visited.contains(num)){
                dfs(num);
            }
        }
    }
}
