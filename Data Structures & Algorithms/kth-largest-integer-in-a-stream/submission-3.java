class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->(a-b));
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
