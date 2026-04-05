class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        int count = 0;

        for(int i=0;i<n;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
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
