class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size()>1){
            int stone1 = pq.remove();
            int stone2 = pq.remove();

            if(stone1!=stone2){
                pq.add(Math.abs(stone1-stone2));
            }
        }

        if(pq.size()==0){
            return 0;
        }

        return pq.remove();   
    }
}
