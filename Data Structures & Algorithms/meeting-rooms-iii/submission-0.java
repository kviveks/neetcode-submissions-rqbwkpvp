

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                long[] room = busyRooms.poll();
                availableRooms.add((int) room[1]);
            }

            if (!availableRooms.isEmpty()) {
                int roomNumber = availableRooms.poll();

                busyRooms.add(new long[] { end, roomNumber });
                count[roomNumber]++;
            } else {
                long[] earliestRoom = busyRooms.poll();

                long freeTime = earliestRoom[0];
                int roomNumber = (int) earliestRoom[1];

                long newEnd = freeTime + duration;

                busyRooms.add(new long[] { newEnd, roomNumber });
                count[roomNumber]++;
            }
        }

        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}