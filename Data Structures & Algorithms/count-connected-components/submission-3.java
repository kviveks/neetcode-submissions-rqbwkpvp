class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        for(int i=0;i<n;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjMap.get(u).add(v);
            adjMap.get(v).add(u);
        }


        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i);
                count++;
            }
        }

        return count;
    }

    public void dfs(int n){
        if(visited.contains(n)){
            return;
        }


        visited.add(n);
        for(int i=0;i<adjMap.get(n).size();i++){
            dfs(adjMap.get(n).get(i));
        }
    }
}
