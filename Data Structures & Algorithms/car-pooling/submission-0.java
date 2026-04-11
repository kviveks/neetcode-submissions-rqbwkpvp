class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] stops = new int[10001];

        for(int[] trip : trips){
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];

            stops[from]+=passenger;
            stops[to]-=passenger;
        }

        int curr = 0;

        for(int i=0;i<1001;i++){
            curr+=stops[i];
            if(curr>capacity){
                return false;
            }

        }

        return true;
    }
}