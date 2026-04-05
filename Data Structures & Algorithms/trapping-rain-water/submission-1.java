class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max = height[0];
        int area = 0;
        for(int i = 1;i<height.length;i++){
            max = Math.max(max,height[i-1]);
            leftMax[i] = max;
        }

        max = height[height.length-1];
        for(int i = height.length-2;i>=0;i--){
            max = Math.max(max,height[i+1]);
            rightMax[i] = max;
        }


        for(int i = 1;i<=height.length-2;i++){
            area = area + Math.max(0,Math.min(leftMax[i],rightMax[i])-height[i]);
        }

        return area;
    }
}
