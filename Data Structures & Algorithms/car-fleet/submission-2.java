class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int n = position.length;
       int[][] pair = new int[n][2];

       for(int i=0;i<n;i++){
        pair[i][0]=position[i];
        pair[i][1]=speed[i];
       }

       Arrays.sort(pair,(a,b)->b[0]-a[0]);

       Deque<Double> stack = new ArrayDeque<Double>();
       for(int[] p : pair){
            double time = (double)(target-p[0])/p[1];
            if(stack.isEmpty() || stack.peekLast() < time){
                stack.addLast(time);
            } 
       }

       return stack.size();
    }
}
