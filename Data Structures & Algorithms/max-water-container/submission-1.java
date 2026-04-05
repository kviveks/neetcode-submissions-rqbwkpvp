class Solution {
    public int maxArea(int[] heights) {
        int s = 0,e = heights.length-1;
        int globalMax = 0;

        while(s<e){
            int area = (e-s)*Math.min(heights[s],heights[e]);
            globalMax = Math.max(globalMax,area);

            if(heights[s]<heights[e]){
                s++;
            }else{
                e--;
            }
        }

        return globalMax;
    }
}
