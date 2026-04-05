class Solution {
    Map<Integer,List<int[]>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    int res = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }

        dfs(k,n,0);

        return res==Integer.MAX_VALUE ? -1 : res;


    }

    public void dfs(int currNode,int n,int time){
        if(visited.contains(currNode)){
            return;
        }

        visited.add(currNode);

        if(visited.size()==n){
            res = Math.min(res,time);
        }


        for(int i=0;i<adj.get(currNode).size();i++){
            int nextnode = adj.get(currNode).get(i)[0];
            int nodetime = adj.get(currNode).get(i)[1];
            dfs(nextnode,n,time+nodetime);
        }

        visited.add(currNode);
    }
}
