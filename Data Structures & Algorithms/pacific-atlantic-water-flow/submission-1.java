class Solution {
    private int m, n;
    private int[][] heights;
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights[i][0]);
            dfs(i, n - 1, atlantic, heights[i][n - 1]);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights[0][j]);
            dfs(m - 1, j, atlantic, heights[m - 1][j]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] ocean, int prevHeight) {
        if (i < 0 || j < 0 || i >= m || j >= n || ocean[i][j] || heights[i][j] < prevHeight) {
            return;
        }

        ocean[i][j] = true;
        for (int[] d : dirs) {
            dfs(i + d[0], j + d[1], ocean, heights[i][j]);
        }
    }
}
