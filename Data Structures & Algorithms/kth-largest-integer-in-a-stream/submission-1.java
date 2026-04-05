class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<Integer>();

        for(int num : nums){
            add(num);
        }   
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size()>k){
            pq.remove();
        }

        return pq.peek();
    }
}
