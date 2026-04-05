class Solution {
    public int trap(int[] height) {

        int l = height.length;

        int[] maxleft = new int[l];
        int[] maxright = new int[l];
        maxleft[0]=0;
        maxright[l-1]=0;

        for(int i = 1; i<l;i++){
            maxleft[i]=Math.max(height[i-1],maxleft[i-1]);
        }

        for(int i = l-2; i>0;i--){
            maxright[i]=Math.max(height[i+1],maxright[i+1]);
        }

        int res = 0;

        for(int i = 1; i<l-1;i++){
            res = res + Math.max(0,Math.min(maxleft[i],maxright[i])-height[i]);
        }

        return res;
        
    }
}
