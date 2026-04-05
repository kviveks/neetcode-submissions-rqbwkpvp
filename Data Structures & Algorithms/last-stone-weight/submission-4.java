class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size()>=2){
            int stone1 = pq.remove();
            int stone2 = pq.remove();

            int newStone = stone1-stone2;
            if(newStone!=0)
                pq.add(newStone);
        }

        return pq.size()==0?0:pq.remove();



    }
}
