class Solution {
    boolean res = false;
    int length;
    int breadth;
    String word;

    public boolean exist(char[][] board, String w) {
        this.word = w;
        this.length = board.length;
        this.breadth = board[0].length;

        boolean[][] visited = new boolean[length][breadth];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                dfs(i, j, 0, visited, board);
                if (res) return true;
            }
        }
        return false;
    }

    public void dfs(int x, int y, int p, boolean[][] visited, char[][] board) {
        if (res) return;

        // bounds check
        if (x < 0 || y < 0 || x >= length || y >= breadth) return;

        // already visited
        if (visited[x][y]) return;

        // character mismatch
        if (board[x][y] != word.charAt(p)) return;

        // found full word
        if (p == word.length() - 1) {
            res = true;
            return;
        }

        visited[x][y] = true;

        dfs(x + 1, y, p + 1, visited, board);
        dfs(x - 1, y, p + 1, visited, board);
        dfs(x, y + 1, p + 1, visited, board);
        dfs(x, y - 1, p + 1, visited, board);

        visited[x][y] = false; // backtrack
    }
}
