class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> row = new HashMap<>();
        HashMap<Integer,HashSet<Character>> col = new HashMap<>();
        HashMap<String,HashSet<Character>> block = new HashMap<>();
        int r=0;
        int c=0;
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){

                if (board[i][j] == '.') continue;

                r = i;
                c = j;

                if(row.containsKey(r)){
                    if(row.get(r).contains(board[i][j])){
                        return false;
                    }
                }else{
                    row.put(r,new HashSet<Character>());    
                }
                row.get(r).add(board[i][j]);


                if(col.containsKey(c)){
                    if(col.get(c).contains(board[i][j])){
                        return false;
                    }
                }else{
                    col.put(c,new HashSet<Character>());    
                }
                col.get(c).add(board[i][j]);


                String key = String.valueOf(r/3)+String.valueOf(c/3);
                if(block.containsKey(key)){
                    if(block.get(key).contains(board[i][j])){
                        return false;
                    }
                }else{
                    block.put(key,new HashSet<Character>());    
                }
                block.get(key).add(board[i][j]);
            }
        }  

        return true;
    }
}
