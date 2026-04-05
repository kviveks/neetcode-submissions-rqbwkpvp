class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] t : times){
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }

        // min time to reach each node
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // {time, node}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if(time > dist[node]) continue;

            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int w = nei[1];

                if(dist[next] > time + w){
                    dist[next] = time + w;
                    pq.add(new int[]{dist[next], next});
                }
            }
        }

        int res = 0;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }

        return res;
    }
}
