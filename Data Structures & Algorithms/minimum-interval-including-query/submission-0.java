class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int m = queries.length;
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] answer = new int[m];
        Arrays.fill(answer, -1);

        int i = 0;

        for (int[] queryInfo : sortedQueries) {
            int query = queryInfo[0];
            int originalIndex = queryInfo[1];

            while (i < intervals.length && intervals[i][0] <= query) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;

                pq.add(new int[] { length, right });
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                answer[originalIndex] = pq.peek()[0];
            }
        }

        return answer;
    }
}