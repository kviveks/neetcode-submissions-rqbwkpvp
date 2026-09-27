class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int currentCombineDiff = 0;
        int globalCombineDiff = Integer.MAX_VALUE;
        int l=0,gL=-1,gR=-1;

        for(int r=0;r<arr.length;r++){
            currentCombineDiff += Math.abs(x-arr[r]);
            if(r-l+1==k){
                if(globalCombineDiff>currentCombineDiff){
                    gL=l;
                    gR=r;
                    globalCombineDiff=currentCombineDiff;
                }
                currentCombineDiff -=Math.abs(x-arr[l++]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=gL;i<=gR;i++){
            res.add(arr[i]);
        }

        return res;
    }
}