class Solution {
    int res=Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        dfs(beginWord,1,visited,endWord,wordList);
        if(res==Integer.MAX_VALUE){
            return 0;
        }
        return res;    
    }

    public void dfs(String input,int laderLength,Set<String> visited,String endWord,List<String> wordList){
        if(input.equals(endWord)){
            res=Math.min(res,laderLength);
        }

        visited.add(input);

        for(String word : wordList){
            if(!visited.contains(word) && rule(input,word)){
                dfs(word,laderLength+1,visited,endWord,wordList);
                visited.remove(word);
            }
        }


    }


    public boolean rule(String input,String word){
        int count=0;
        for(int i = 0;i<input.length();i++){
            if(input.charAt(i)!=word.charAt(i)){
                count++;
            }
        }

        if(count==1){
            return true;
        }
        return false;
    }
}
