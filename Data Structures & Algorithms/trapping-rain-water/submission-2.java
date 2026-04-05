class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int currentMax = 0;
        for(int i = 0;i<height.length;i++){
            currentMax = Math.max(currentMax,height[i]);
            leftMax[i]=currentMax;
        }

        currentMax = 0;
        for(int i = height.length-1;i>=0;i--){
            currentMax= Math.max(currentMax,height[i]);
            rightMax[i]=currentMax;
        }

        int area=0;
        for(int i =0;i<height.length;i++){
            area = area + Math.max(Math.min(leftMax[i],rightMax[i])-height[i],0);
        }

        return area;
    }
}
