class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i=0;i<=n-1;i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){
            if(map.get(i).size()==0){
                return false;
            }
        }


        for(int i = 0;i<=n-1;i++){
            if(!dfs(i,-1)){
                return false;
            }
        }

        return true;
    }


    public boolean dfs(int node,int previous){
        if(visited.contains(node)){
            return false;
        }
        boolean result = true;
        visited.add(node);
        for(int i = 0;i<map.get(node).size();i++){
            if(previous!=map.get(node).get(i)){
                result = result && dfs(map.get(node).get(i),node);
            }
        }

        visited.remove(node);

        if(result==false){
            return false;
        }

        return true;
    }
}
