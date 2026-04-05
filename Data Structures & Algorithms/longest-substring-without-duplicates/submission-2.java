class Solution {
    public int lengthOfLongestSubstring(String s) {
        int globalMax=1;
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int localMax = 0;
        int i;
        for(i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                globalMax = Math.max(globalMax,i-start);
                for(int j = start; j<i;j++){
                    if(s.charAt(j)!=ch){
                        set.remove(s.charAt(j));
                    }else{
                        start = j+1;
                    }
                }    
            }else{
                set.add(ch);
            }
        }

        globalMax = Math.max(globalMax,i-start);

        return globalMax;


        
    }
}
