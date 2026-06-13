class Solution {
    int res = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(i, j, grid);
            }
        }

        return res;
    }

    public int dfs(int x, int y, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0; // mark visited

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int area = 1; // count current cell

        for (int[] dir : dirs) {
            area += dfs(x + dir[0], y + dir[1], grid);
        }

        res = Math.max(res, area);

        return area;
    }
}