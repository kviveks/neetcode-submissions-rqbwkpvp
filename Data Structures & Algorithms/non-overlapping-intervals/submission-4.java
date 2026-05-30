class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);
        int count = 0;

        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            int prevStart = res.get(res.size()-1)[0];
            int prevEnd = res.get(res.size()-1)[1];

            if(prevEnd > start){
                res.get(res.size()-1)[1]=Math.min(end,prevEnd);
                count++;
            }else{
                res.add(intervals[i]);
            }
        }

        return count;
    }
}
