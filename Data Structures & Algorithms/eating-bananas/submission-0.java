class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        for(int i = 0;i<piles.length;i++){
            max= Math.max(max,piles[i]);
        }

        int l = 1;
        int r = max-1;
        int res = Integer.MAX_VALUE;
        while(l<=r){
            int mid = (l+r)/2;
            int k = mid;
            int nh = 0;
            for(int i = 0;i < piles.length;i++){
                nh = nh + (int)Math.ceil((double)piles[i]/k);    
            }

            if(nh<=h){
                res=Math.min(k,res);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return res;
        
    }
}
