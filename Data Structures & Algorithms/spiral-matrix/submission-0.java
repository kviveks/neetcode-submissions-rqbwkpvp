class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();

        while (left <= right && top <= bottom) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;  // Move the top boundary downwards

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;  // Move the right boundary leftwards

            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;  // Move the bottom boundary upwards
            }

            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;  // Move the left boundary rightwards
            }
        }

        return res;
    }
}
