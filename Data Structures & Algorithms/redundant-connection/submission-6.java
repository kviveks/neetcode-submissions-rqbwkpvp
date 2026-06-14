class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!union(u,v,parent,rank)){
                return edge;
            }
        }

        return new int[]{};
    }

    private int find(int node,int[] parent){
        if(parent[node]!=node){
            parent[node]=find(parent[node],parent);
        }

        return parent[node];
    }

    private boolean union(int u,int v,int[] parent,int[] rank){
        int parentU = find(u,parent);
        int parentV = find(v,parent);

        if(parentU==parentV){
            return false;
        }

        if(rank[parentU]>rank[parentV]){
            parent[parentV]=parentU;
            rank[parentU]+=rank[parentV];
        }else{
            parent[parentU]=parentV;
            rank[parentV]+=rank[parentU];
        }

        return true;


    }
}
