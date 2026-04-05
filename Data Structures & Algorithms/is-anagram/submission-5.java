class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;

        int[] sArray = new int[26];
        int[] tArray = new int[26];


        for(char ch : s.toCharArray()){
            sArray[ch-'a']++;
        }

        for(char ch : t.toCharArray()){
            tArray[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(sArray[i]!=tArray[i])
                return false;
        }

        return true;


    }
}
