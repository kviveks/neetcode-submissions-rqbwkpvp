class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            int preStart = res.get(res.size()-1)[0];
            int preEnd = res.get(res.size()-1)[1];

            if(start<=preEnd){
                res.get(res.size()-1)[1]=Math.max(preEnd,end);
            }else{
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);  
    }
}
