class Solution {
    public boolean isValidSudoku(char[][] board) {


        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];

                if (curr != '.') {
                    String rowKey = "row" + i + "-" + curr;
                    String colKey = "col" + j + "-" + curr;
                    String boxKey = "box" + (i / 3) + (j / 3) + "-" + curr;

                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }

        return true;

        
    }
}

