class Solution {
    public int findKthLargest(int[] nums, int k) {
     PriorityQueue<Integer> pq = new  PriorityQueue<>(Comparator.reverseOrder());
     for(int num : nums){
        pq.add(num);
     }
     int n=-1;
     for(int i=1;i<=k;i++){
        n=pq.poll();
     }

     return n;


    }
}
