class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int maxArea=0;

        int currentMax = 0;

        for(int i=0;i<height.length;i++){
            left[i]=currentMax;
            currentMax =Math.max(currentMax,height[i]);
        }

        currentMax = 0;

        for(int i = height.length-1;i>=0;i--){
            right[i]=currentMax;
            currentMax = Math.max(currentMax,height[i]);
        }


        for(int i=0;i<height.length;i++){
            maxArea+= Math.max(Math.min(left[i],right[i])-height[i],0);
        }   

        return maxArea;
    }
}
