class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int currentCombineDiff = 0;
        int globalCombineDiff = Integer.MAX_VALUE;
        int resL = -1;
        int resR = -1;


        int l = 0;
        for(int r=0;r<arr.length;r++){
            currentCombineDiff = currentCombineDiff + Math.abs(x-arr[r]);
            if(r-l+1==k){
                if(globalCombineDiff>currentCombineDiff){
                    resL=l;
                    resR=r;
                    globalCombineDiff = currentCombineDiff;
                }
                
                currentCombineDiff = currentCombineDiff - Math.abs(x-arr[l++]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=resL;i<=resR;i++){
            res.add(arr[i]);
        }

        return res;
    }
}