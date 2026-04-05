class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Step 1: Traverse boundary and mark connected 'O's
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board);
            }
        }

        // Step 2: Flip the surrounded 'O's to 'X's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        // Step 3: Restore the boundary-connected 'O's to their original state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        board[x][y] = '#'; // Mark as visited

        // Directions: Up, Down, Left, Right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            // Check boundaries and make sure it's an 'O' that hasn't been visited
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
                dfs(nx, ny, board);
            }
        }
    }
}
