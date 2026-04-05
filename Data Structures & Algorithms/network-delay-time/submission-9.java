class Solution {
    Map<Integer,List<int[]>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    int[] res;
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }

        res= new int[n+1];
        for(int i=1;i<=n;i++){
            res[i] = Integer.MAX_VALUE;
        }


        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }

        dfs(k,n,0);
        int result = Integer.MIN_VALUE;
        for(int i =1;i<=n;i++){
            result = Math.max(res[i],result);
        }

        if(result==Integer.MAX_VALUE)
            return -1;

        return result;


    }

    public void dfs(int currNode,int n,int time){
        if(visited.contains(currNode)){
            return;
        }

        visited.add(currNode);

        res[currNode]=Math.min(res[currNode],time);


        for(int i=0;i<adj.get(currNode).size();i++){
            int nextnode = adj.get(currNode).get(i)[0];
            int nodetime = adj.get(currNode).get(i)[1];
            dfs(nextnode,n,time+nodetime);
        }

        visited.remove(currNode);
    }
}
