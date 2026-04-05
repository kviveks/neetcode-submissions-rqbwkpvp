public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int n = intervals.length;
        int preEnd = intervals[0][1];
        int count = 0;
        for(int i =1;i<n;i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];


            if(curStart < preEnd){
                count++;
                preEnd = Math.min(preEnd,curEnd);
            }else{
                preEnd = curEnd;
            }
        }

        return count;

        
    }
}