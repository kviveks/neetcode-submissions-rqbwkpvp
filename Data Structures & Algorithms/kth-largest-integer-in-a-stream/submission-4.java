class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>((a,b)->(a-b));
        this.k = k;
        for(int num : nums){
            add(num);
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.remove();
        }

        return pq.peek();
    }
}
