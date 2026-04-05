class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);    
        }
        int count =0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                count++;
                dfs(i);
            }
        }

        return count;
    }

    public void dfs(int node){
        if(visited.contains(node)){
            return;
        }

        visited.add(node);


        for(int n : adj.get(node)){
            dfs(n);
        }
    }
}
