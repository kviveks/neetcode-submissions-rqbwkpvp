class KthLargest {
    PriorityQueue<Integer> pq;
    int size;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->(a-b));
        size = k;
        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>size){
            pq.remove();
        }
        return pq.peek();
    }
}
