class Solution {
    int[] res;
    Map<Integer,List<int[]>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        res = new int[n+1];
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.get(u).add(new int[]{v,t});
        }

        for(int i=1;i<=n;i++){
            res[i] = Integer.MAX_VALUE;
        }

        Set<Integer> visited = new HashSet<Integer>();
        dfs(k,0,visited,n);

        int result = Integer.MIN_VALUE;
        for(int i =1;i<=n;i++){
            result = Math.max(res[i],result);
        }

        if(result==Integer.MAX_VALUE)
            return -1;

        return result;
    }


    public void dfs(int node,int time,Set<Integer> visited,int n){
        if(visited.contains(node)){
            return;
        }

        visited.add(node);
        res[node] = Math.min(res[node],time);

        for(int[] neigh : adj.get(node)){
            int v = neigh[0];
            int t = neigh[1];
            dfs(v,time+t,visited,n);
        }
    }
}
