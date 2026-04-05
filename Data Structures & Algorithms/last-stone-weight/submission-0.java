class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if(x>y){
                pq.add(x-y);
            }else if(y>x){
                pq.add(y-x);
            }
        }

        if(pq.size()==1){
            return pq.poll();
        }

        return 0;

    }
}
