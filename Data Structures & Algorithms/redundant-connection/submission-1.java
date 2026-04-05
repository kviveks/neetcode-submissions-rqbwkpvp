class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for(int[] edge : edges){
            if(set.contains(edge[0])&&set.contains(edge[1])){
                return new int[]{edge[0],edge[1]};
            }else{
                set.add(edge[0]);
                set.add(edge[1]);
            }
        }

        return new int[]{};
    }
}
