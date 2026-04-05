class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;
        int l = 0,r=len-1;
        int result = 0;

        while(l<r){
            int area = Math.min(heights[r],heights[l])*(r-l);
            result = Math.max(result,area);
            if(heights[r]<=heights[l]){
                r--;
            }else{
                l++;
            }
        }

        return result;    
    }
}
