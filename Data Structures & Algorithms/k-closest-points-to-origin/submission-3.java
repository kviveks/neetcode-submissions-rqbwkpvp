class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> pq = new PriorityQueue<>((p2,p1)->(p1[0]*p1[0]+p1[1]*p1[1]-p2[0]*p2[0]-p2[1]*p2[1]));


       for(int[] point : points){
            pq.add(point);
            if(pq.size()>k){
                pq.remove();
            }
       } 

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.remove();
        }
        return res;

    }
}
