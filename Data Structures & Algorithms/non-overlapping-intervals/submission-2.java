class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int count = 0;

        for(int i=1;i<intervals.length;i++){
            if(res.get(res.size()-1)[1]>intervals[i][0]){
                res.get(res.size()-1)[1]=Math.min(intervals[i][1],res.get(res.size()-1)[1]);
                count++;
            }
        }
        return count;

    }
}
