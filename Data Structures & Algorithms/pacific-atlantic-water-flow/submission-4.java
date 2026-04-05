class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];

        for(int i = 0; i < m; i++) {
            dfs(i, 0, pac, heights);     // Pacific Ocean - left boundary
            dfs(i, n - 1, atl, heights); // Atlantic Ocean - right boundary
        }

        for(int j = 0; j < n; j++) {
            dfs(0, j, pac, heights);     // Pacific Ocean - top boundary
            dfs(m - 1, j, atl, heights); // Atlantic Ocean - bottom boundary
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pac[i][j] == 1 && atl[i][j] == 1) {
                    res.add(Arrays.asList(i, j)); // Add coordinates that can reach both oceans
                }
            }
        }

        return res;
    }

    public void dfs(int x, int y, int[][] ocean, int[][] heights) {
        // Avoid revisiting already visited cells
        if(ocean[x][y] == 1) {
            return;
        }

        int m = heights.length;
        int n = heights[0].length;

        ocean[x][y] = 1;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            // Make sure we're within bounds and the current cell height is less than or equal to the next cell
            if(newX >= 0 && newX < m && newY >= 0 && newY < n) {
                if(heights[newX][newY] >= heights[x][y]) {
                    dfs(newX, newY, ocean, heights);
                }
            }
        }
    }
}
