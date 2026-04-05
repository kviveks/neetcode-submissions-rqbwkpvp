class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->(a-b));
        this.k = k;
        for(int i =0;i<nums.length;i++){
            add(nums[i]);
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
