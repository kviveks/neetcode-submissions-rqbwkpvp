/*
s = "zxyzxyz"



*/
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int result = 1;
        int l =0;
        for(int i = 0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;  
            }
            set.add(s.charAt(i));
            result = Math.max(result,set.size());
        }

        return result;
        
    }
}
