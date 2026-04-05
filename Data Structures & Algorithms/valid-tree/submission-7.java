class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    boolean res = true;
    public boolean validTree(int n, int[][] edges) {
        if(n!=edges.length+1){
            return false;
        }

        for(int i=0;i<n;i++){
            adjMap.put(i,new ArrayList<>());
        }

        //build adj map

        for(int[] edge : edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        dfs(0,-1);

        if(res==false)
            return false;

        if(visited.size()==n){
            return true;
        }else{
            return false;
        }

    }

    public void dfs(int edge,int parent){
        if(res==false){
            return;
        }
        if(visited.contains(edge)){
            res=false;
            return;
        }


        visited.add(edge);


        for(int i=0;i<adjMap.get(edge).size();i++){
            if(adjMap.get(edge).get(i)!=parent){
                dfs(adjMap.get(edge).get(i),edge);
                if(res==false){
                    return;
                }
            }
        }
    }
}
