class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> validWordStart = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        int n = s.length();
        validWordStart.add(n);
        for(String word : wordDict){
            wordSet.add(word);
        }

        for(int i = n-1;i>=0;i--){
            for(int index : validWordStart){
                String sub = s.substring(i,index);
                if(wordSet.contains(sub)){
                    validWordStart.add(i);
                    break;
                }
            }
        }

        return validWordStart.contains(0);


    }
}
