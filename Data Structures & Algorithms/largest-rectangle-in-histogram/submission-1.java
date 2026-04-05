class Solution {
    public int largestRectangleArea(int[] heights) {
            Stack<int[]> st = new Stack<>();
            int max = 0;

            for (int i = 0; i < heights.length; i++) {
                if (st.isEmpty() || st.peek()[0] < heights[i]) {
                    st.push(new int[]{heights[i], i});
                } else {
                    int[] curr = null;
                    while (!st.isEmpty() && st.peek()[0] > heights[i]) {
                        curr = st.pop();
                        max = Math.max(curr[0] * (i - curr[1]), max);
                    }
                    if (curr != null) {
                        st.push(new int[]{heights[i], curr[1]});
                    } else {
                        st.push(new int[]{heights[i], i});
                    }
                }
            }

            while (!st.isEmpty()) {
                int[] curr = st.pop();
                max = Math.max(curr[0] * (heights.length - curr[1]), max);
            }

            return max;
        }
    }
